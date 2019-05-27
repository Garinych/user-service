package md.codefactory.userservice.controller;

import lombok.RequiredArgsConstructor;
import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.exceptions.EmailAlreadyExistException;
import md.codefactory.userservice.exceptions.PhoneNumberAlreadyExistException;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.exceptions.UsernameAlreadyExistException;
import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.mapping.dto.AdminUserDto;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.mapping.dto.UserProfileDto;
import md.codefactory.userservice.repository.RoleRepository;
import md.codefactory.userservice.repository.UsersRepository;
import md.codefactory.userservice.services.MapValidationErrorService;
import md.codefactory.userservice.services.UsersServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user-services/users")
public class UsersController {


    private final UsersServices usersServices;
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final MapValidationErrorService mapValidationErrorService;
    private final RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody NewUserDto newUserDto, BindingResult result) throws UsernameAlreadyExistException, EmailAlreadyExistException, PhoneNumberAlreadyExistException, ProfileNotFountException {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

        User newUser = userMapper.newUserDtoToUser(newUserDto);
        usersServices.saveUser(newUser);

        return new ResponseEntity<>(userMapper.userToNewUserDto(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/profile/{username}")
    public UserProfileDto userProfile(@PathVariable String username) throws Exception {

        User user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new ProfileNotFountException("User with username = " + username + " not found!"));

        return userMapper.userToUserProfileDto(user);
    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @Valid @RequestBody UpdateUserDto updateUserDto, BindingResult result) throws UsernameAlreadyExistException, EmailAlreadyExistException, PhoneNumberAlreadyExistException, ProfileNotFountException {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;
        User updateUser = userMapper.updateUserDtoToUser(updateUserDto);
        usersServices.updateUser(username, updateUser);

        return new ResponseEntity<>(userMapper.userToUpdateUserDto(updateUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) throws ProfileNotFountException {
        User user = usersRepository.findById(id).orElseThrow(()-> new ProfileNotFountException("User with id = " + id + " not found!"));

        usersRepository.delete(user);

        return new ResponseEntity<>("User " + id + " deleted !", HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public List<AdminUserDto> findAllUsers(@PathVariable String username) throws Exception {

        User admin = usersRepository.findByUsername(username).orElseThrow(()-> new ProfileNotFountException("User with username = " + username + " not found!"));

        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new ProfileNotFountException("User Role not set"));

        if(admin.getRole().equals(Collections.singleton(userRole))) {
            List<User> user = usersRepository.findAll();
            return userMapper.userToAdminUserDto(user);
        } else {
            throw new Exception("Not enought rights !");
        }

    }


}

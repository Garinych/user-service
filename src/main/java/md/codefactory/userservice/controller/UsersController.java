package md.codefactory.userservice.controller;

import lombok.RequiredArgsConstructor;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.exceptions.EmailAlreadyExistException;
import md.codefactory.userservice.exceptions.PhoneNumberAlreadyExistException;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.exceptions.UsernameAlreadyExistException;
import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.mapping.dto.UserProfileDto;
import md.codefactory.userservice.repository.UsersRepository;
import md.codefactory.userservice.services.MapValidationErrorService;
import md.codefactory.userservice.services.UsersServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/users")
public class UsersController {


    private final UsersServices usersServices;
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody NewUserDto newUserDto, BindingResult result) throws UsernameAlreadyExistException, EmailAlreadyExistException, PhoneNumberAlreadyExistException, ProfileNotFountException {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

        User newUser = userMapper.newUserDtoToUser(newUserDto);
        usersServices.saveUser(newUser);

        return new ResponseEntity<>(userMapper.userToNewUserDto(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserProfileDto userProfile(@PathVariable Long id) throws Exception {

        User user = usersRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFountException("User with id = " + id + " not found!"));

        return userMapper.userToUserProfileDto(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDto updateUserDto, BindingResult result) throws UsernameAlreadyExistException, EmailAlreadyExistException, PhoneNumberAlreadyExistException, ProfileNotFountException {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;
        User updateUser = userMapper.updateUserDtoToUser(updateUserDto);
        usersServices.updateUser(id, updateUser);

        return new ResponseEntity<>(userMapper.userToUpdateUserDto(updateUser), HttpStatus.OK);
    }




}

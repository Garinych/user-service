package md.codefactory.userservice.controller;

import lombok.RequiredArgsConstructor;
import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.mapping.dto.AdminUserDto;
import md.codefactory.userservice.repository.RoleRepository;
import md.codefactory.userservice.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/admin/users")
public class AdminUsersController {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;


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

package md.codefactory.userservice.controller;

import lombok.RequiredArgsConstructor;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.mapping.dto.AdminUserDto;
import md.codefactory.userservice.repository.RoleRepository;
import md.codefactory.userservice.repository.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/admin/users")
public class AdminUsersController {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws ProfileNotFountException {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFountException("User with id = " + id + " not found!"));

        usersRepository.delete(user);

        return new ResponseEntity<>("User " + id + " deleted !", HttpStatus.OK);
    }


    @GetMapping
    public Page<AdminUserDto> findAllUsers(Pageable pageable) {
        return usersRepository.findAll(pageable).map(user1 -> userMapper.userToAdminUserDto(user1));
    }
}

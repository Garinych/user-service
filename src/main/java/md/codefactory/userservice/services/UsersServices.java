package md.codefactory.userservice.services;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.exceptions.EntityAlreadyExistsException;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.repository.RoleRepository;
import md.codefactory.userservice.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersServices {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository usersRepository;

    public User saveUser(User user) throws EntityAlreadyExistsException, ProfileNotFountException {

        alreadyExistExceptions(user);

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new ProfileNotFountException("User Role not set"));

        user.setRole(Collections.singleton(userRole));

        return usersRepository.save(user);
    }

    public User updateUser(Long id, User user) throws EntityAlreadyExistsException, ProfileNotFountException {
        User updatedUser = usersRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFountException("User with id = " + id + " not found!"));

        BeanUtils.copyProperties(user, updatedUser, "id");

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new ProfileNotFountException("User Role not set"));

        updatedUser.getRole().add(userRole); //if add role exist dont do enifing if role doesnt exist put role in the field

        alreadyExistExceptions(updatedUser);

        return usersRepository.save(updatedUser);
    }

    public void alreadyExistExceptions(User user) throws EntityAlreadyExistsException {
        Optional<User> existEmail = usersRepository.findByEmail(user.getEmail());

        Long userId = user.getId();

        if (existEmail.isPresent() && !existEmail.get().getId().equals(userId)) {
            throw new EntityAlreadyExistsException("Email " + user.getEmail() + " already exist !!!");
        }

        Optional<User> existPhoneNumber = usersRepository.findByPhoneNumber(user.getPhoneNumber());

        if (existPhoneNumber.isPresent() && !existPhoneNumber.get().getId().equals(userId)) {
            throw new EntityAlreadyExistsException("Phone Number " + user.getPhoneNumber() + " already exist !!!");
        }

        Optional<User> existUsername = usersRepository.findByUsername(user.getUsername());

        if (existUsername.isPresent() && !existUsername.get().getId().equals(userId)) {
            throw new EntityAlreadyExistsException("Username " + user.getUsername() + " already exist !!!");
        }
    }
}

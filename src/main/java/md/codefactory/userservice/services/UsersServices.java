package md.codefactory.userservice.services;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.exceptions.EmailAlreadyExistException;
import md.codefactory.userservice.exceptions.PhoneNumberAlreadyExistException;
import md.codefactory.userservice.exceptions.ProfileNotFountException;
import md.codefactory.userservice.exceptions.UsernameAlreadyExistException;
import md.codefactory.userservice.repository.RoleRepository;
import md.codefactory.userservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UsersServices {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository usersRepository;

    public User saveUser(User user) throws EmailAlreadyExistException, PhoneNumberAlreadyExistException, UsernameAlreadyExistException, ProfileNotFountException {

        alreadyExistExceptions(user);

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new ProfileNotFountException("User Role not set"));

        user.setRole(Collections.singleton(userRole));

        return usersRepository.save(user);
    }

    public User updateUser(Long id, User user) throws EmailAlreadyExistException, PhoneNumberAlreadyExistException, UsernameAlreadyExistException, ProfileNotFountException {
        User updatedUser = usersRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFountException("User with id = " + id + " not found!"));

        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setPassword(user.getPassword());

        updatedUser.setRole(updatedUser.getRole());

        alreadyExistExceptions(updatedUser);

        return usersRepository.save(updatedUser);
    }

    public void alreadyExistExceptions(User user) throws EmailAlreadyExistException, PhoneNumberAlreadyExistException, UsernameAlreadyExistException {
        Optional<User> existEmail = usersRepository.findByEmail(user.getEmail());

        Long userId = user.getId();

        if(existEmail.isPresent() && !existEmail.get().getId().equals(userId)){
            throw new EmailAlreadyExistException("Email " + user.getEmail() + " already exist !!!");
        }

        Optional<User> existPhoneNumber = usersRepository.findByPhoneNumber(user.getPhoneNumber());

        if(existPhoneNumber.isPresent() && !existPhoneNumber.get().getId().equals(userId)){
            throw new PhoneNumberAlreadyExistException("Phone Number " + user.getPhoneNumber() + " already exist !!!");
        }

        Optional<User> existUsername = usersRepository.findByUsername(user.getUsername() );

        if(existUsername.isPresent() && !existUsername.get().getId().equals(userId)){
            throw new UsernameAlreadyExistException("Username " + user.getUsername() + " already exist !!!");
        }
    }
}

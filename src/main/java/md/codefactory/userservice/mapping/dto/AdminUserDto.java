package md.codefactory.userservice.mapping.dto;

import lombok.Getter;
import lombok.Setter;
import md.codefactory.userservice.domain.Role;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class AdminUserDto {

    String firstName;

    String lastName;

    String email;

    String phoneNumber;

    String username;

    String password;

    List<Role> role;
}

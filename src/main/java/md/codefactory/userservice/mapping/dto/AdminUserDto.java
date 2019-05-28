package md.codefactory.userservice.mapping.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AdminUserDto {

    String id;

    String firstName;

    String lastName;

    String email;

    String phoneNumber;

    String username;

    String password;

    Set<RoleDto> role;
}

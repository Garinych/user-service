package md.codefactory.userservice.mapping.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AdminUserDto {

    private String id;

    private String firstName;
    private String lastName;

    private String email;

    private String phoneNumber;

    private String username;

    private String password;

    private Set<RoleDto> role;
}

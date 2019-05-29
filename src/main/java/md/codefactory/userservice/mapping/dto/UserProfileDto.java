package md.codefactory.userservice.mapping.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String username;

    private String password;
}

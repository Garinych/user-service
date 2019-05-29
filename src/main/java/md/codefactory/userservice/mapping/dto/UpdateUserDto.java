package md.codefactory.userservice.mapping.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateUserDto {

    @NotBlank
    @Size(min = 3, max = 20, message = "First name length mast be min - 3 , max - 20 !")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contains only letters")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 20, message = "Last name length mast be min - 3 , max - 20 !")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contains only letters")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 9, max = 20, message = "Phone number size mast be min - 9, max - 20 and contains only Numbers !")
    private String phoneNumber;

    @NotBlank
    @Size(min = 5, max = 20, message = "Username length mast be min - 5 , max - 20 !")
    private String username;

    @NotBlank
    private String password;

}

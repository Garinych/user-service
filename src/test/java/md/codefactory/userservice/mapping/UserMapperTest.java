package md.codefactory.userservice.mapping;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.domain.enums.RoleName;
import md.codefactory.userservice.mapping.dto.AdminUserDto;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.mapping.dto.UserProfileDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    public final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void should_map_newUserDto_to_user() {

        NewUserDto newUserDto = new NewUserDto();
        newUserDto.setFirstName("Vasea");
        newUserDto.setLastName("Pliush");
        newUserDto.setEmail("vasea.pliush@codefactory.com");
        newUserDto.setPhoneNumber("069545454");
        newUserDto.setUsername("vasea.pliush1");
        newUserDto.setPassword("vasea123");

        User user = userMapper.newUserDtoToUser(newUserDto);

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(newUserDto.getFirstName());
        assertThat(user.getLastName()).isEqualTo(newUserDto.getLastName());
        assertThat(user.getEmail()).isEqualTo(newUserDto.getEmail());
        assertThat(user.getPhoneNumber()).isEqualTo(newUserDto.getPhoneNumber());
        assertThat(user.getUsername()).isEqualTo(newUserDto.getUsername());
        assertThat(user.getPassword()).isEqualTo(newUserDto.getPassword());

    }

    @Test
    public void should_map_user_to_newUserDto() {

        User user = new User();
        user.setFirstName("Vasea");
        user.setLastName("Pliush");
        user.setEmail("vasea.pliush@codefactory.com");
        user.setPhoneNumber("069545454");
        user.setUsername("vasea.pliush1");
        user.setPassword("vasea123");

        NewUserDto newUserDto = userMapper.userToNewUserDto(user);

        assertThat(newUserDto).isNotNull();
        assertThat(newUserDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(newUserDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(newUserDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(newUserDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(newUserDto.getUsername()).isEqualTo(user.getUsername());
        assertThat(newUserDto.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    public void should_map_updateUserDto_to_user() {

        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setFirstName("Vasea");
        updateUserDto.setLastName("Pliush");
        updateUserDto.setEmail("vasea.pliush@codefactory.com");
        updateUserDto.setPhoneNumber("069545454");
        updateUserDto.setUsername("vasea.pliush1");
        updateUserDto.setPassword("vasea123");

        User user = userMapper.updateUserDtoToUser(updateUserDto);

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(updateUserDto.getFirstName());
        assertThat(user.getLastName()).isEqualTo(updateUserDto.getLastName());
        assertThat(user.getEmail()).isEqualTo(updateUserDto.getEmail());
        assertThat(user.getPhoneNumber()).isEqualTo(updateUserDto.getPhoneNumber());
        assertThat(user.getUsername()).isEqualTo(updateUserDto.getUsername());
        assertThat(user.getPassword()).isEqualTo(updateUserDto.getPassword());

    }

    @Test
    public void should_map_user_to_updateUserDto() {

        User user = new User();
        user.setFirstName("Vasea");
        user.setLastName("Pliush");
        user.setEmail("vasea.pliush@codefactory.com");
        user.setPhoneNumber("069545454");
        user.setUsername("vasea.pliush1");
        user.setPassword("vasea123");

        UpdateUserDto updateUserDto = userMapper.userToUpdateUserDto(user);

        assertThat(updateUserDto).isNotNull();
        assertThat(updateUserDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(updateUserDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(updateUserDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(updateUserDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(updateUserDto.getUsername()).isEqualTo(user.getUsername());
        assertThat(updateUserDto.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    public void should_map_userProfileDto_to_user() {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFirstName("Vasea");
        userProfileDto.setLastName("Pliush");
        userProfileDto.setEmail("vasea.pliush@codefactory.com");
        userProfileDto.setPhoneNumber("069545454");
        userProfileDto.setUsername("vasea.pliush1");
        userProfileDto.setPassword("vasea123");

        User user = userMapper.userProfileDtoToUser(userProfileDto);

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(userProfileDto.getFirstName());
        assertThat(user.getLastName()).isEqualTo(userProfileDto.getLastName());
        assertThat(user.getEmail()).isEqualTo(userProfileDto.getEmail());
        assertThat(user.getPhoneNumber()).isEqualTo(userProfileDto.getPhoneNumber());
        assertThat(user.getUsername()).isEqualTo(userProfileDto.getUsername());
        assertThat(user.getPassword()).isEqualTo(userProfileDto.getPassword());
    }

    @Test
    public void should_map_user_ti_userProfileDto() {
        User user = new User();
        user.setFirstName("Vasea");
        user.setLastName("Pliush");
        user.setEmail("vasea.pliush@codefactory.com");
        user.setPhoneNumber("069545454");
        user.setUsername("vasea.pliush1");
        user.setPassword("vasea123");

        UserProfileDto userProfileDto = userMapper.userToUserProfileDto(user);

        assertThat(userProfileDto).isNotNull();
        assertThat(userProfileDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userProfileDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(userProfileDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userProfileDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(userProfileDto.getUsername()).isEqualTo(user.getUsername());
        assertThat(userProfileDto.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void should_map_user_to_adminUserDto() {
        User user = new User();
        user.setFirstName("Vasea");
        user.setLastName("Pliush");
        user.setEmail("vasea.pliush@codefactory.com");
        user.setPhoneNumber("069545454");
        user.setUsername("vasea.pliush1");
        user.setPassword("vasea123");

        Role role = new Role();
        role.setName(RoleName.ROLE_USER);

        AdminUserDto adminUserDto = userMapper.userToAdminUserDto(user);

        assertThat(adminUserDto).isNotNull();
        assertThat(adminUserDto.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(adminUserDto.getLastName()).isEqualTo(user.getLastName());
        assertThat(adminUserDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(adminUserDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(adminUserDto.getUsername()).isEqualTo(user.getUsername());
        assertThat(adminUserDto.getPassword()).isEqualTo(user.getPassword());
        assertThat(adminUserDto.getRole()).isEqualTo(user.getRole());
    }


}
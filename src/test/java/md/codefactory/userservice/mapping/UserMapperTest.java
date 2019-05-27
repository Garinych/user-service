package md.codefactory.userservice.mapping;

import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.mapping.dto.NewUserDto;
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

}
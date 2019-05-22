package md.codefactory.userservice.mapping;

import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.mapping.dto.UserProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User newUserDtoToUser(NewUserDto newUserDto);

    NewUserDto userToNewUserDto(User user);

    User updateUserDtoToUser(UpdateUserDto updateUserDto);

    UpdateUserDto userToUpdateUserDto(User user);

    User userProfileDtoToUser(UserProfileDto userProfileDto);

    UserProfileDto userToUserProfileDto(User user);
}

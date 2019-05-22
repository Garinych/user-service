package md.codefactory.userservice.mapping;

import javax.annotation.Generated;
import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.mapping.dto.UserProfileDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-22T10:41:34+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User newUserDtoToUser(NewUserDto newUserDto) {
        if ( newUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( newUserDto.getFirstName() );
        user.setLastName( newUserDto.getLastName() );
        user.setEmail( newUserDto.getEmail() );
        if ( newUserDto.getPhoneNumber() != null ) {
            user.setPhoneNumber( Integer.parseInt( newUserDto.getPhoneNumber() ) );
        }
        user.setUsername( newUserDto.getUsername() );
        user.setPassword( newUserDto.getPassword() );

        return user;
    }

    @Override
    public NewUserDto userToNewUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        NewUserDto newUserDto = new NewUserDto();

        newUserDto.setFirstName( user.getFirstName() );
        newUserDto.setLastName( user.getLastName() );
        newUserDto.setEmail( user.getEmail() );
        if ( user.getPhoneNumber() != null ) {
            newUserDto.setPhoneNumber( String.valueOf( user.getPhoneNumber() ) );
        }
        newUserDto.setUsername( user.getUsername() );
        newUserDto.setPassword( user.getPassword() );

        return newUserDto;
    }

    @Override
    public User updateUserDtoToUser(UpdateUserDto updateUserDto) {
        if ( updateUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( updateUserDto.getFirstName() );
        user.setLastName( updateUserDto.getLastName() );
        user.setEmail( updateUserDto.getEmail() );
        if ( updateUserDto.getPhoneNumber() != null ) {
            user.setPhoneNumber( Integer.parseInt( updateUserDto.getPhoneNumber() ) );
        }
        user.setUsername( updateUserDto.getUsername() );
        user.setPassword( updateUserDto.getPassword() );

        return user;
    }

    @Override
    public UpdateUserDto userToUpdateUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UpdateUserDto updateUserDto = new UpdateUserDto();

        updateUserDto.setFirstName( user.getFirstName() );
        updateUserDto.setLastName( user.getLastName() );
        updateUserDto.setEmail( user.getEmail() );
        if ( user.getPhoneNumber() != null ) {
            updateUserDto.setPhoneNumber( String.valueOf( user.getPhoneNumber() ) );
        }
        updateUserDto.setUsername( user.getUsername() );
        updateUserDto.setPassword( user.getPassword() );

        return updateUserDto;
    }

    @Override
    public User userProfileDtoToUser(UserProfileDto userProfileDto) {
        if ( userProfileDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userProfileDto.getFirstName() );
        user.setLastName( userProfileDto.getLastName() );
        user.setEmail( userProfileDto.getEmail() );
        if ( userProfileDto.getPhoneNumber() != null ) {
            user.setPhoneNumber( Integer.parseInt( userProfileDto.getPhoneNumber() ) );
        }
        user.setUsername( userProfileDto.getUsername() );
        user.setPassword( userProfileDto.getPassword() );

        return user;
    }

    @Override
    public UserProfileDto userToUserProfileDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserProfileDto userProfileDto = new UserProfileDto();

        return userProfileDto;
    }
}

package ee.mainor.demo.mapper;

import ee.mainor.demo.dto.CreateUserRequest;
import ee.mainor.demo.dto.UserDto;
import ee.mainor.demo.model.User;

public class UserMapper {



    public static User updateEntity(UserDto source, User target) {
        target.setLogin(source.getLogin());
        return target;
    }

    public static UserDto toDto(User request) {
        UserDto userDto = new UserDto();
        userDto.setId(request.getId());
        userDto.setLogin(request.getLogin());
        return userDto;
    }


    public static User toEntity(CreateUserRequest request) {
        User user = new User();
        user.setLogin(request.getLogin());
        return user;
    }

}


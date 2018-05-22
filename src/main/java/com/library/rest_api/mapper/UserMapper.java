package com.library.rest_api.mapper;

import com.library.rest_api.domain.User;
import com.library.rest_api.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto maptoUserDto(User user) {
        return new UserDto(user.getUserId(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getDateOfCreation(),
                user.getListOfLoans()
        );
    }

    public User maptoUser(UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUserFirstName(),
                userDto.getUserLastName(),
                userDto.getDateOfCreation(),
                userDto.getListOfLoans()
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(u -> new UserDto(u.getUserId(),
                        u.getUserFirstName(),
                        u.getUserLastName(),
                        u.getDateOfCreation(),
                        u.getListOfLoans()))
                .collect(Collectors.toList());
    }

    public List<User> mapToUserList(List<UserDto> users) {
        return users.stream()
                .map(u -> new User(u.getUserId(),
                        u.getUserFirstName(),
                        u.getUserLastName(),
                        u.getDateOfCreation(),
                        u.getListOfLoans()))
                .collect(Collectors.toList());
    }
}

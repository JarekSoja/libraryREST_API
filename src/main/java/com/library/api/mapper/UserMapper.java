package com.library.api.mapper;

import com.library.api.domain.User;
import com.library.api.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private LoanMapper loanMapper;

    public UserDto maptoUserDto(User user) {
        return new UserDto(user.getUserId(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getDateOfCreation(),
                loanMapper.mapToLoanDtoList(user.getListOfLoans())
        );
    }

    public User maptoUser(UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUserFirstName(),
                userDto.getUserLastName(),
                userDto.getDateOfCreation(),
                loanMapper.mapToLoanList(userDto.getListOfLoans())
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(u -> new UserDto(u.getUserId(),
                        u.getUserFirstName(),
                        u.getUserLastName(),
                        u.getDateOfCreation(),
                        loanMapper.mapToLoanDtoList(u.getListOfLoans())))
                .collect(Collectors.toList());
    }
}

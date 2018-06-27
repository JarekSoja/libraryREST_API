package com.library.api.mapper;

import com.library.api.domain.User;
import com.library.api.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapToUserDto() {
        //Given
        User user = new User("1", "2");

        //When
        UserDto userDto = userMapper.maptoUserDto(user);
        String testFristName = userDto.getUserFirstName();
        String testLastName = userDto.getUserLastName();

        //Then
        Assert.assertEquals("1", testFristName);
        Assert.assertEquals("2", testLastName);
    }

    @Test
    public void mapToUser() {
        //Given
        UserDto userDto = new UserDto("1", "2");

        //When
        User user = userMapper.maptoUser(userDto);
        String testFristName = user.getUserFirstName();
        String testLastName = user.getUserLastName();

        //Then
        Assert.assertEquals("1", testFristName);
        Assert.assertEquals("2", testLastName);
    }

    @Test
    public void mapToUserDtoList() {
        //Given
        User user = new User("1", "2");
        User user2 = new User("3", "4");
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(user);
        listOfUsers.add(user2);

        //When
        List<UserDto> listOfUsersDto = userMapper.mapToUserDtoList(listOfUsers);
        String testFirstName = listOfUsersDto.get(0).getUserFirstName();
        String testLastName = listOfUsersDto.get(1).getUserLastName();

        //Then
        Assert.assertEquals("1", testFirstName);
        Assert.assertEquals("4", testLastName);
    }
}

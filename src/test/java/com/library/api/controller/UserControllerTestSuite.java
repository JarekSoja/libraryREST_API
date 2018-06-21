package com.library.api.controller;

import com.google.gson.Gson;
import com.library.api.domain.User;
import com.library.api.dto.UserDto;
import com.library.api.mapper.UserMapper;
import com.library.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTestSuite {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void shouldFetchEmptyUserList() throws Exception {
        //Given
        User user = new User("1", "2");
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(user);
        List<UserDto> listOfUsersDto = new ArrayList<>();
        when(userMapper.mapToUserDtoList(listOfUsers)).thenReturn(listOfUsersDto);

        //When&&Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchUserList() throws Exception {
        //Given
        List<User> listOfUsers = new ArrayList<>();
        List<UserDto> listOfUsersDto = new ArrayList<>();
        UserDto user = new UserDto("1", "2");
        listOfUsersDto.add(user);
        when(userMapper.mapToUserDtoList(listOfUsers)).thenReturn(listOfUsersDto);

        //When&&Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].userFirstName", is("1")));
    }

    @Test
    public void shouldFetchUser() throws Exception {
        //Given
        User user = new User("1", "2");
        UserDto userDto = new UserDto("1", "2");
        when(userMapper.maptoUserDto(user)).thenReturn(userDto);
        when(userMapper.maptoUser(userDto)).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);
        when(userService.getUserById(anyLong())).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);

        //When&&Then
        mockMvc.perform(get("/users/)")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "444"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.userFirstName", is("1")));
    }

    @Test
    public void shouldCreateUser() throws Exception {

        User user = new User("1", "2");
        when(userMapper.maptoUser(any(UserDto.class))).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);
        //When&&Then
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userFirstName", is("1")));

    }

}

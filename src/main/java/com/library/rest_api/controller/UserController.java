package com.library.rest_api.controller;

import com.library.rest_api.dto.UserDto;
import com.library.rest_api.mapper.UserMapper;
import com.library.rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userService.getAll());
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable("id") Long userId) {
        return userMapper.maptoUserDto(userService.getUserById(userId));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.maptoUser(userDto));
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(value = "/{id}")
    public UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        return userMapper.maptoUserDto(userService.saveUser(userMapper.maptoUser(userDto)));
    }

    @GetMapping(value = "/{searchedString}")
    public List<UserDto> retrieveUsersWithNameContaining(@PathVariable("searchedString") String searchedString) {
        return userMapper.mapToUserDtoList(userService.getUsersWithNameContaining(searchedString));
    }

    @GetMapping(value = "/overdue")
    public List<UserDto> retrieveUsersWithOverdueLoans() {
        return userMapper.mapToUserDtoList(userService.getUsersWithOverdueLoans());
    }


}

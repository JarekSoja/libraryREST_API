package com.library.api.controller;

import com.library.api.domain.User;
import com.library.api.dto.UserDto;
import com.library.api.mapper.UserMapper;
import com.library.api.service.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;



    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userService.getAll());
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@RequestParam("id") Long userId) {
        return userMapper.maptoUserDto(userService.getUserById(userId));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userMapper.maptoUser(userDto));
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(value = "/{id}")
    public UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        User user = userMapper.maptoUser(userDto);
        userService.updateUser(user, userId);
        return userMapper.maptoUserDto(user);
    }

    @GetMapping(value = "/search/{searchedString}")
    public List<UserDto> retrieveUsersWithNameContaining(@PathVariable("searchedString") String searchedString) {
        return userMapper.mapToUserDtoList(userService.getUsersWithNameContaining(searchedString));
    }

    @GetMapping(value = "/overdue")
    public List<UserDto> retrieveUsersWithOverdueLoans() {
        return userMapper.mapToUserDtoList(userService.getUsersWithOverdueLoans());
    }


}

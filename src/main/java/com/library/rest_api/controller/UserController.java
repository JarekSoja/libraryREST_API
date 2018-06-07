package com.library.rest_api.controller;

import com.library.rest_api.domain.User;
import com.library.rest_api.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping
    List<UserDto> getAllUsers() {
        return null;
    }

    @GetMapping(value = "/{id}")
    UserDto getUser(@PathVariable("id") Long userId) {
        return null;
    }

    @PostMapping
    User user(@RequestBody UserDto userDto) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    void removeUser(@PathVariable("id") Long userId) {
    }

    @PutMapping(value = "/{id}")
    UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        return null;
    }

    @GetMapping(value = "/{searchedString}")
    List<UserDto> retrieveUsersWithNameContaining(@PathVariable("searchedString") String searchedString) {
        return null;
    }

    @GetMapping(value = "/overdue")
    List<User> retrieveUsersWithOverdueLoans() {
        return null;
    }

}

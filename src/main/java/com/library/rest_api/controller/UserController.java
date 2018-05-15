package com.library.rest_api.controller;

import com.library.rest_api.domain.NewUser;
import com.library.rest_api.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RestController
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    List<UserDto> getAllUsers(){
        return null; }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    UserDto getUser(@PathVariable ("id") Long userId) { return null; }

    @RequestMapping(method = RequestMethod.POST)
    NewUser newUser(@RequestBody UserDto userDto) { return null; }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removeUser(@PathVariable ("id") Long userId) {  }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) { return null; }

}

package com.library.rest_api.controller;

import com.library.rest_api.domain.NewUser;
import com.library.rest_api.Dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public interface UserControllerInterface {

    @RequestMapping(method = RequestMethod.GET)
    List<UserDto> getAllUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    UserDto getUser(@PathVariable ("id") Long userId);

    @RequestMapping(method = RequestMethod.POST)
    NewUser newUser(@RequestBody UserDto userDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removeUser(@PathVariable ("id") Long userId);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id{")
    UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto);

}

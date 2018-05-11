package com.library.rest_api.controller;

import com.library.rest_api.domain.NewUser;
import com.library.rest_api.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public interface UserControllerInterface {

    @RequestMapping(method = RequestMethod.GET, value = "getAllUsers")
    List<UserDto> getAllUsers();

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    UserDto getUser(@RequestParam Long userId);

    @RequestMapping(method = RequestMethod.POST, value = "newUser")
    NewUser newUser(@RequestBody UserDto userDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "removeUser")
    void removeUser(@RequestParam Long userId);

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    UserDto updateUser(@RequestBody UserDto userDto);

}

package com.library.rest_api.service;

import com.library.rest_api.domain.User;
import com.library.rest_api.dto.UserDto;
import com.library.rest_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.getUserByUserId(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersWithOverdueLoans() {
        return userRepository.retrieveUsersWithOverdueLoans();
    }

    public List<User> getUsersWithNameContaining(String name) {
        return userRepository.retrieveUsersWithNameContaining(name);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}



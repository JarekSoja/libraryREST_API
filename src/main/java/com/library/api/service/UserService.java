package com.library.api.service;

import com.library.api.config.UserNotFoundException;
import com.library.api.domain.User;
import com.library.api.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(User user, Long userId) {
        User actualUser = userRepository.getUserByUserId(userId);
        if (actualUser != null) {
            user.setUserId(userId);
            return userRepository.save(user);
        } else {
            return null;
            //TODO Exception

        }
    }
}



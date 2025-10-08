package com.example.crud.postgressql.service;

import com.example.crud.postgressql.entity.User;
import com.example.crud.postgressql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        return this.userRepository.findById(id).map(u -> {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            return userRepository.save(u);
        }).orElse(null);
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}

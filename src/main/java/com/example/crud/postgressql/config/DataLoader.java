package com.example.crud.postgressql.config;

import com.example.crud.postgressql.entity.User;
import com.example.crud.postgressql.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if database is empty
        if (userRepository.count() == 0) {
            // Add mock users
            userRepository.save(new User(null, "Alice", "alice@example.com"));
            userRepository.save(new User(null, "Bob", "bob@example.com"));
            userRepository.save(new User(null, "Charlie", "charlie@example.com"));
            System.out.println("Mock users loaded successfully!");
        }
    }
}


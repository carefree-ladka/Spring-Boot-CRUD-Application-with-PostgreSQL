package com.example.crud.postgressql.repository;

import com.example.crud.postgressql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

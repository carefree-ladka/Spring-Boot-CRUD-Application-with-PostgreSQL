package com.example.crud.postgressql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can not be empty")
    @Size(max = 20, message = "Name must be at most 20 characters")
    private String name;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Email should be valid")
    @Size(max = 50, message = "Email must be at most 50 characters")
    private String email;
}

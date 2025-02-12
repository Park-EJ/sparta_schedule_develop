package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUsersByUsername(String username); // Query Methods 활용

    default User findUsersByUsernameOrElseThrow(String username) { // Default 메서드 활용
        return findUsersByUsername(username).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Does not exists username : " + username));
    }

    Optional<User> findByEmail(String email);
}

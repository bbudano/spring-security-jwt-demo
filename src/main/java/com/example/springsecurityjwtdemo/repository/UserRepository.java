package com.example.springsecurityjwtdemo.repository;

import com.example.springsecurityjwtdemo.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}

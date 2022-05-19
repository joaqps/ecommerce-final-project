package com.example.domain_connectors;

import com.example.domain.domain.User;

import java.util.Optional;

public interface UserService {

  Optional<User> findByUsername(String username);

  void saveUser(String username, String password);
}

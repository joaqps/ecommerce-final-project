package com.example.outbound_connectors.mappers;

import com.example.domain.domain.User;

import java.util.Optional;

public interface UserOutPort {

  Optional<User> findByUsername(String username);

  void save(User user);
}

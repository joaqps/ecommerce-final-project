package com.example.outbound_connectors;

import com.example.domain.domain.User;

import java.util.Optional;

public interface UserDAO {

	Optional<User> findByUsername(String username);

	User save(User user);
}

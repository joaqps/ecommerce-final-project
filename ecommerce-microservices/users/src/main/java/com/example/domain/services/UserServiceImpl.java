package com.example.domain.services;

import com.example.domain.domain.User;
import com.example.domain_connectors.UserService;
import com.example.outbound_connectors.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	// private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public User save(String username, String password) {
		return userDAO.save(User.builder().username(username).password(password).build());
	}
}

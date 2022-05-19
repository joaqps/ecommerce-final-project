package com.example.domain.services;

import com.example.domain.domain.User;
import com.example.domain_connectors.UserService;
import com.example.outbound_connectors.mappers.UserOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserOutPort outPort;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Optional<User> findByUsername(String username) {
    return outPort.findByUsername(username);
  }

  @Override
  public void saveUser(String username, String password) {

    outPort.save(User.builder().username(username).password(passwordEncoder.encode(password)).build());
  }
}

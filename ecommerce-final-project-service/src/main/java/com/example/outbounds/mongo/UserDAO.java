package com.example.outbounds.mongo;

import com.example.domain.domain.User;
import com.example.outbound_connectors.mappers.UserEntityMapper;
import com.example.outbound_connectors.mappers.UserOutPort;
import com.example.outbounds.mongo.entities.UserEntity;
import com.example.outbounds.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDAO implements UserOutPort {

  private final UserRepository repository;
  private final UserEntityMapper mapper;

  @Override
  public Optional<User> findByUsername(String username) {

    Optional<UserEntity> entity = repository.findByUsername(username);

    return entity.map(mapper::mapEntity);
  }

  @Override
  public void save(User user) {
    repository.save(mapper.mapVo(user));
  }
}

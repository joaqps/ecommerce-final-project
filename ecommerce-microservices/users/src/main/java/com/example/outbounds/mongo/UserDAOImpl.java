package com.example.outbounds.mongo;

import com.example.domain.domain.User;
import com.example.outbound_connectors.mappers.UserEntityMapper;
import com.example.outbound_connectors.UserDAO;
import com.example.outbounds.mongo.entities.UserEntity;
import com.example.outbounds.mongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDAOImpl implements UserDAO {

	private final UserRepository repository;
	private final UserEntityMapper mapper;

	@Override
	public Optional<User> findByUsername(final String username) {

		Optional<UserEntity> entity = repository.findByUsername(username);

		return entity.map(mapper::mapEntity);
	}

	@Override
	public User save(final User user) {

		UserEntity savedUser = repository.save(mapper.mapVo(user));

		return mapper.mapEntity(savedUser);
	}
}

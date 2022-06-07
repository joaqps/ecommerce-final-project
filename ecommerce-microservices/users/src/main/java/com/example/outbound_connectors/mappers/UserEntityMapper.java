package com.example.outbound_connectors.mappers;

import com.example.domain.domain.User;
import com.example.outbounds.mongo.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

	User mapEntity(UserEntity entity);

	UserEntity mapVo(User vo);
}

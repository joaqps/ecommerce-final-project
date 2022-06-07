package com.example.domain_connectors.mappers;

import com.example.domain.domain.User;
import com.example.inbounds.rest.dtos.UserRequestDTO;
import com.example.inbounds.rest.dtos.UserResponseDTO;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper extends DtoMapper<UserRequestDTO, User, UserResponseDTO> {
}

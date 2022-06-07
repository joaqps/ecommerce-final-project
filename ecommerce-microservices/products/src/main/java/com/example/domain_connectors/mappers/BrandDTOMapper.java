package com.example.domain_connectors.mappers;

import com.example.domain.Brand;
import com.example.inbounds.rest.dtos.BrandResponseDTO;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoResponseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandDTOMapper extends DtoResponseMapper<Brand, BrandResponseDTO> {
}

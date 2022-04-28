package com.example.domain_connectors.mappers;

import com.example.inbounds.rest.dtos.ProductResponseDTO;
import com.example.domain.domain.Product;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoResponseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper extends DtoResponseMapper<Product, ProductResponseDTO> {
}

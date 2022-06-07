package com.example.domain_connectors.mappers;

import com.example.domain.Product;
import com.example.inbounds.rest.dtos.ProductRequestDTO;
import com.example.inbounds.rest.dtos.ProductResponseDTO;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper extends DtoMapper<ProductRequestDTO, Product, ProductResponseDTO> {
}

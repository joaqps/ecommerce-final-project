package com.example.domain_connectors.mappers;

import com.example.inbounds.rest.dtos.ProductRequestDTO;
import com.example.domain.domain.Product;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoRequestMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper extends DtoRequestMapper<ProductRequestDTO, Product> {
}

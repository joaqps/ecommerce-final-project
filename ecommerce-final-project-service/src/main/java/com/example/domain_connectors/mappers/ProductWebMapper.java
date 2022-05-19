package com.example.domain_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.inbounds.web.dtos.ProductWebDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductWebMapper {

  ProductWebDTO of(Product vo);
}

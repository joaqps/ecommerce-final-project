package com.example.outbound_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.outbounds.csv.dtos.ProductCSVDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCsvMapper {

  ProductCSVDTO of(Product vo);
}

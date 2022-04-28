package com.example.domain_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class ProductKafkaConsumerMapper {

  private ObjectMapper mapper;

  @Autowired
  public void setMapper(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Mapping(target = "endOfSaleDate", source = "dto", qualifiedByName = "endOfSaleDate")
  public abstract Product of(ProductKafkaDTO dto);

  @Named("endOfSaleDate")
  public LocalDateTime mapEndOfSaleDate(final ProductKafkaDTO dto) {
    return mapper.convertValue(dto.getEndOfSaleDate(), LocalDateTime.class);
  }
}

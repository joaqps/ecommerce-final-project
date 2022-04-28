package com.example.outbound_connectors.mappers;

import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductKafkaProducerMapper {

  private ObjectMapper mapper;

  @Autowired
  public void setMapper(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Mapping(target = "endOfSaleDate", source = "vo", qualifiedByName = "endOfSaleDate")
  public abstract ProductKafkaDTO of(Product vo);

  @Named("endOfSaleDate")
  public String mapEndOfSaleDate(final Product vo) {
    return mapper.convertValue(vo.getEndOfSaleDate(), String.class);
  }
}

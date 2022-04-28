package com.example.outbound_connectors.mappers;

import com.example.outbounds.mongo.entities.ProductEntity;
import com.example.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

  ProductEntity mapVo(Product vo);

  Product mapEntity(ProductEntity entity);
}

package com.example.outbound_connectors.mappers;

import com.example.domain.Product;
import org.mapstruct.Mapper;
import com.example.outbounds.mongo.entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

	ProductEntity mapVo(Product vo);

	Product mapEntity(ProductEntity entity);
}

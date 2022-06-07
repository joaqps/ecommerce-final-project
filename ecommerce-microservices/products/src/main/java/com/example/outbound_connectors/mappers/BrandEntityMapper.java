package com.example.outbound_connectors.mappers;

import com.example.domain.Brand;
import com.example.outbounds.mongo.entities.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {

	Brand mapEntity(BrandEntity entity);
}

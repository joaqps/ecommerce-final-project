package com.example.outbound_connectors.mappers;

import com.example.outbounds.mongo.entities.RateEntity;
import com.example.domain.domain.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateEntityMapper {

  Rate mapEntity(RateEntity entity);
}

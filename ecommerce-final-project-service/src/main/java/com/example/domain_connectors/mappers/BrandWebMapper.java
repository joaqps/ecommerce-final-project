package com.example.domain_connectors.mappers;

import com.example.domain.domain.Brand;
import com.example.inbounds.web.dtos.BrandWebDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandWebMapper {

  BrandWebDTO of(Brand vo);
}

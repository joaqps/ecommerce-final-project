package com.example.domain_connectors.mappers;

import com.example.domain.Rate;
import com.example.inbounds.rest.dtos.RateResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RateResponseMapper {

	@Mapping(target = "rateId", source = "vo.id")
	RateResponseDTO mapResponse(Rate vo);
}

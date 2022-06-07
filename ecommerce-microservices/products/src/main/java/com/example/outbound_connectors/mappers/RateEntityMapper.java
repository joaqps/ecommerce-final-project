package com.example.outbound_connectors.mappers;

import com.example.domain.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.example.outbounds.mongo.entities.RateEntity;

@Mapper(componentModel = "spring")
public interface RateEntityMapper {

	@Mapping(target = "brandId", source = "entity", qualifiedByName = "brand")
	@Mapping(target = "productId", source = "entity", qualifiedByName = "product")
	Rate mapEntity(RateEntity entity);

	@Named("brand")
	default String mapBrand(final RateEntity entity) {

		if (entity.getBrand() != null) {
			return entity.getBrand().getId();
		}
		return null;
	}

	@Named("product")
	default String mapProduct(final RateEntity entity) {

		if (entity.getProduct() != null) {
			return entity.getProduct().getId();
		}
		return null;
	}
}

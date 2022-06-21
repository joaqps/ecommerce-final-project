package com.example.commons.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceChangeRequestDTO {

	public static final TypeReference<PriceChangeRequestDTO> JSON_TYPE_REF = new TypeReference<>() {
	};

	private String rateId;

	private BigDecimal price;
}

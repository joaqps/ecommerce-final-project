package com.example.inbounds.rest.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateResponseDTO {

	public static final TypeReference<RateResponseDTO> JSON_TYPE_REF = new TypeReference<>() {
	};

	private String productId;
	private String brandId;
	private String rateId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
}

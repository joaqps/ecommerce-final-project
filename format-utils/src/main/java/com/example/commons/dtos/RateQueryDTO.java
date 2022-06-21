package com.example.commons.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateQueryDTO {

	public static final TypeReference<RateQueryDTO> JSON_TYPE_REF = new TypeReference<>() {
	};

	private String productId;

	private String brandId;

	private LocalDateTime date;
}

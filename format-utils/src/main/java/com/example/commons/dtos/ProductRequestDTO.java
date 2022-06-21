package com.example.commons.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

	public static final TypeReference<ProductRequestDTO> JSON_TYPE_REF = new TypeReference<>() {
	};

	private String id;

	private String name;

	private String category;

	private LocalDateTime endOfSaleDate;
}

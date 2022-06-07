package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	private String id;
	private String name;
	private String category;
	private LocalDateTime endOfSaleDate;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

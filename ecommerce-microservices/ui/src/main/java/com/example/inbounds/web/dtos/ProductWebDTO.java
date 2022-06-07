package com.example.inbounds.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWebDTO {

	private String id;
	private String name;
	private String category;
	private LocalDateTime endOfSaleDate;
}

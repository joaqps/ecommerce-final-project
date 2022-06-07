package com.example.outbounds.mongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "products")
public class ProductEntity {

	@Id
	private String id;
	private String name;
	private String category;
	private LocalDateTime endOfSaleDate;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

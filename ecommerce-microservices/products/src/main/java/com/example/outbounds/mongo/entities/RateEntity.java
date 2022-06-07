package com.example.outbounds.mongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "rates")
public class RateEntity {

	@Id
	private String id;
	@DBRef
	private BrandEntity brand;
	@DBRef
	private ProductEntity product;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
	private BigDecimal price;
	private String currency;
}

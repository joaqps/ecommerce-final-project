package com.example.outbounds.mongo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("users")
public class UserEntity {

	@Id
	private String id;
	@Indexed(unique = true)
	private String username;
	private String password;
	// @DBRef
	// private List<BrandEntity> followedBrands;
}

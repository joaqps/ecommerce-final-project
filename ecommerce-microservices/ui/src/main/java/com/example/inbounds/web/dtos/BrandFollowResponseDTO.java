package com.example.inbounds.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandFollowResponseDTO {

	private boolean isSuccessful;
	private String message;
}

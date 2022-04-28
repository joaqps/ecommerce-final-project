package com.example.inbounds.rest.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

  public static final TypeReference<ProductResponseDTO> JSON_TYPE_REF = new TypeReference<ProductResponseDTO>() {
  };

  private String id;
  private String name;
  private String category;
  private LocalDateTime endOfSaleDate;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}

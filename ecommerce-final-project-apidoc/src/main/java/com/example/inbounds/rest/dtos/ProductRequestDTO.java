package com.example.inbounds.rest.dtos;

import com.example.inbounds.rest.format.LocalDateTimeFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

  public static final TypeReference<ProductRequestDTO> JSON_TYPE_REF = new TypeReference<ProductRequestDTO>() {
  };

  private String id;

  @NotNull
  private String name;

  @NotNull
  private String category;

  @NotNull
  @Schema(example = LocalDateTimeFormat.EXAMPLE)
  private LocalDateTime endOfSaleDate;
}

package com.example.inbounds.rest.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceChangeRequestDTO {

  public static final TypeReference<PriceChangeRequestDTO> JSON_TYPE_REF = new TypeReference<PriceChangeRequestDTO>() {
  };

  @NotNull
  private String rateId;

  @NotNull
  private BigDecimal price;
}

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
public class RateQueryDTO {

  public static final TypeReference<RateQueryDTO> JSON_TYPE_REF = new TypeReference<RateQueryDTO>() {
  };

  @NotNull
  private String productId;

  @NotNull
  private String brandId;

  @NotNull
  @Schema(example = LocalDateTimeFormat.EXAMPLE)
  private LocalDateTime date;
}

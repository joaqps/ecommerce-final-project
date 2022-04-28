package com.example.domain.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

  private String id;
  private String brandId;
  private String productId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priority;
  private BigDecimal price;
  private String currency;
}

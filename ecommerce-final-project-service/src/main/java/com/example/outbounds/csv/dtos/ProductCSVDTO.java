package com.example.outbounds.csv.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCSVDTO {

  private String id;
  private String name;
  private String category;
  private LocalDateTime endOfSaleDate;
}

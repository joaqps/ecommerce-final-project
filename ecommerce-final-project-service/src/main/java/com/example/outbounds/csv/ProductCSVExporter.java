package com.example.outbounds.csv;

import com.example.domain.domain.Product;
import com.example.outbound_connectors.ProductCSVOutPort;
import com.example.outbound_connectors.mappers.ProductCsvMapper;
import com.example.outbounds.csv.dtos.ProductCSVDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductCSVExporter implements ProductCSVOutPort {

  private final ProductCsvMapper mapper;

  @Override
  public String exportAllToCSV(List<Product> products) {

    List<ProductCSVDTO> dtos = products.stream().map(mapper::of).collect(Collectors.toList());
    String csv = this.convertToCSV(dtos);
    String filename = "products.csv";

    try {
      Files.write(Paths.get("exports/" + filename), csv.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return filename;
  }

  private String convertToCSV(List<ProductCSVDTO> products) {

    StringBuilder stringBuilder = new StringBuilder();

    products.forEach(product -> stringBuilder.append(product.getId()).append(";").append(product.getName()).append(";")
        .append(product.getCategory()).append(";").append(product.getEndOfSaleDate()));

    return stringBuilder.toString();
  }
}

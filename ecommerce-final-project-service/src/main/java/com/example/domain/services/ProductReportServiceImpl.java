package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain_connectors.ProductReportService;
import com.example.outbound_connectors.ProductCSVOutPort;
import com.example.outbound_connectors.ProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReportServiceImpl implements ProductReportService {

  private final ProductOutPort outPort;
  private final ProductCSVOutPort outCsvPort;

  @Override
  public String exportAll(String email) {

    List<Product> products = outPort.findAll();
    return outCsvPort.exportAllToCSV(products);
  }
}

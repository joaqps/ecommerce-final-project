package com.example.outbound_connectors;

import com.example.domain.domain.Product;

import java.util.List;

public interface ProductCSVOutPort {

  String exportAllToCSV(List<Product> products);
}

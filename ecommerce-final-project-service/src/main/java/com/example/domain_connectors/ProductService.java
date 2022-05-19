package com.example.domain_connectors;

import com.example.domain.domain.Product;

import java.util.List;

public interface ProductService {

  void saveAndNotify(Product vo);

  void update(Product vo);

  void delete(String id);

  List<Product> findAll();
}

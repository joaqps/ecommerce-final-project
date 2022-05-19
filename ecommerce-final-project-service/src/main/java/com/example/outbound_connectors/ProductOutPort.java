package com.example.outbound_connectors;

import com.example.domain.domain.Product;

import java.util.List;

public interface ProductOutPort {

  Product save(Product entity);

  Product update(Product entity);

  void delete(String id);

  boolean exists(String id);

  List<Product> findAll();
}

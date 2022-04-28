package com.example.outbound_connectors;

import com.example.domain.domain.Product;

public interface ProductOutPort {

  Product save(Product entity);

  Product update(Product entity);

  void delete(String id);

  boolean exists(String id);
}

package com.example.outbound_connectors;

import com.example.domain.domain.Product;
import com.example.domain.domain.User;

import java.util.List;

public interface ProductNotificationOutPort {

  void notifyNewProduct(List<User> users, Product newProduct);
}

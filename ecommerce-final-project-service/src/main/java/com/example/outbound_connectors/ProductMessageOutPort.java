package com.example.outbound_connectors;

import com.example.domain.domain.Product;

public interface ProductMessageOutPort {

  String sendCreateMessage(Product vo);

  String sendUpdateMessage(Product vo);

  String sendDeleteMessage(String id);
}

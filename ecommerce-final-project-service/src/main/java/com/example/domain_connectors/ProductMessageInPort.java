package com.example.domain_connectors;

import com.example.domain.domain.Product;

public interface ProductMessageInPort {

  String sendCreateMessage(Product vo);

  String sendUpdateMessage(Product vo);

  String sendDeleteMessage(String id);
}

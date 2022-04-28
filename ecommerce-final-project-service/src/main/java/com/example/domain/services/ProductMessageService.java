package com.example.domain.services;

import com.example.domain.domain.Product;
import com.example.domain_connectors.ProductMessageInPort;
import com.example.outbound_connectors.ProductMessageOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductMessageService implements ProductMessageInPort {

  private final ProductMessageOutPort outPort;

  @Override
  public String sendCreateMessage(final Product vo) {

    if (vo.getId() != null) {
      return "Id found. Try updating instead.";
    }

    return outPort.sendCreateMessage(vo);
  }

  @Override
  public String sendUpdateMessage(final Product vo) {

    if (vo.getId() == null) {
      return "Id not found. Try inserting instead.";
    }

    return outPort.sendUpdateMessage(vo);
  }

  @Override
  public String sendDeleteMessage(final String id) {
    return outPort.sendDeleteMessage(id);
  }
}

package com.example.outbounds.kafka;

import com.example.domain.domain.Product;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import com.example.outbound_connectors.ProductMessageOutPort;
import com.example.outbound_connectors.mappers.ProductKafkaProducerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductKafkaProducer implements ProductMessageOutPort {

  private final KafkaTemplate<String, ProductKafkaDTO> kafkaTemplateDTO;
  private final KafkaTemplate<String, String> kafkaTemplateStr;
  private final ProductKafkaProducerMapper mapper;

  @Override
  public String sendCreateMessage(final Product vo) {

    ProductKafkaDTO dto = mapper.of(vo);
    kafkaTemplateDTO.send("product-create", dto);

    return "Product create message sent";
  }

  @Override
  public String sendUpdateMessage(final Product vo) {

    ProductKafkaDTO dto = mapper.of(vo);
    kafkaTemplateDTO.send("product-update", dto);

    return "Product update message sent";
  }

  @Override
  public String sendDeleteMessage(final String id) {

    kafkaTemplateStr.send("product-delete", id);

    return "Product delete message sent";
  }
}

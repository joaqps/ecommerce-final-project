package com.example.inbounds.kafka;

import com.example.domain.domain.Product;
import com.example.domain_connectors.ProductInPort;
import com.example.domain_connectors.mappers.ProductKafkaConsumerMapper;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductKafkaConsumer {

  private final Logger logger = LoggerFactory.getLogger(ProductKafkaConsumer.class);

  private final ProductInPort inPort;
  private final ProductKafkaConsumerMapper mapper;

  @KafkaListener(topics = "product-create")
  public void onSave(final ConsumerRecord<String, ProductKafkaDTO> message) {

    Product vo = mapper.of(message.value());
    inPort.save(vo);
  }

  @KafkaListener(topics = "product-update")
  public void onUpdate(final ConsumerRecord<String, ProductKafkaDTO> message) {

    Product vo = mapper.of(message.value());
    inPort.update(vo);
  }

  @KafkaListener(topics = "product-delete")

  public void onDelete(final ConsumerRecord<String, String> message) {

    String id = message.value();
    inPort.delete(id);
  }
}

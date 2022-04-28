package com.example.inbounds.kafka;

import com.example.domain_connectors.ProductInPort;
import com.example.domain_connectors.mappers.ProductKafkaConsumerMapper;
import com.example.inbounds.kafka.dtos.ProductKafkaDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductKafkaConsumerTest {

  @Mock
  ProductInPort inPort;
  @Mock
  ProductKafkaConsumerMapper mapper;
  @InjectMocks
  ProductKafkaConsumer kafkaConsumer;

  @Test
  void test_save() {

    kafkaConsumer.onSave(new ConsumerRecord<>("products", 1, 1, "1", new ProductKafkaDTO()));

    verify(mapper).of(any());
    verify(inPort).save(any());
  }

  @Test
  void test_update() {

    kafkaConsumer.onUpdate(new ConsumerRecord<>("products", 1, 1, "1", new ProductKafkaDTO()));

    verify(mapper).of(any());
    verify(inPort).update(any());
  }

  @Test
  void test_delete() {

    kafkaConsumer.onDelete(new ConsumerRecord<>("products", 1, 1, "1", "1"));

    verify(inPort).delete(any());
  }
}
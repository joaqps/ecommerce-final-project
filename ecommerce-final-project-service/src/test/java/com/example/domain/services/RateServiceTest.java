package com.example.domain.services;

import com.example.domain.domain.Rate;
import com.example.domain.exceptions.RateNotFoundException;
import com.example.outbound_connectors.RateOutPort;
import com.example.outbounds.kafka.RateKafkaProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) class RateServiceTest {

  @Mock RateOutPort outPort;
  @Mock RateKafkaProducer kafkaProducer;
  @InjectMocks RateService service;

  @Test void test_find() {

    service.findByProductIdBrandIdAndDate("1", "1", LocalDateTime.now());

    verify(outPort).findByProductIdBrandIdAndDate(any(), any(), any());
  }

  @Test void test_price_change() {

    when(outPort.exists(any())).thenReturn(true);

    service.sendPriceChangeMessage("1", BigDecimal.valueOf(35.5));

    verify(kafkaProducer).sendPriceChangeMessage(any(), any());
  }

  @Test void test_price_change_not_found() {

    when(outPort.exists(any())).thenReturn(false);

    RuntimeException thrown = assertThrows(RateNotFoundException.class,
        () -> service.sendPriceChangeMessage("1", BigDecimal.ONE));

    assertEquals("Rate with specified id not found.", thrown.getMessage());
  }

  @Test void test_update() {

    service.updateRate(new Rate());

    verify(outPort).updateRate(any());
  }
}
package com.example.inbounds.web;

import com.example.domain_connectors.ProductService;
import com.example.domain_connectors.ProductReportService;
import com.example.domain_connectors.mappers.ProductWebMapper;
import com.example.inbounds.web.dtos.ProductWebDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ecommerce/products")
@RequiredArgsConstructor
public class ProductWebController {

  private final ProductService inPort;
  private final ProductReportService reportInPort;
  private final ProductWebMapper mapper;

  @GetMapping
  public String findAll(Model model) {

    List<ProductWebDTO> products = this.inPort.findAll().stream().map(mapper::of).collect(Collectors.toList());

    model.addAttribute("products", products);

    return "products";
  }

  @PostMapping(value = "/export", produces = "application/json")
  @ResponseBody
  public String exportAll(@RequestParam String email) {

    return "{\"response\": \"OK\"}";
  }
}

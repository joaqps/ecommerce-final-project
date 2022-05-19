package com.example.inbounds.web;

import com.example.domain_connectors.BrandService;
import com.example.domain_connectors.mappers.BrandWebMapper;
import com.example.inbounds.web.dtos.BrandWebDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ecommerce/brands")
@RequiredArgsConstructor
public class BrandWebController {

  private final BrandService inPort;
  private final BrandWebMapper mapper;

  @GetMapping
  public String findAll(Model model) {

    List<BrandWebDTO> brands = this.inPort.findAll().stream().map(mapper::of).collect(Collectors.toList());

    model.addAttribute("brands", brands);

    return "brands";
  }
}

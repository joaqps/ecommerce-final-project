package com.example.outbounds.mail.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewProductMailDTO {

  private String id;
  private String name;
  private String category;
  private String userEmail;
}

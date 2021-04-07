package com.marvel.marvel.dto;

import lombok.Data;
import java.util.List;
import java.util.Date;

@Data
public class CreateUserDto {
  private List<DocumentDto> documents;
  private String name;
  private String email;
  private String password;
  private String phone;
  private String gender;
  private Date birthday;
}

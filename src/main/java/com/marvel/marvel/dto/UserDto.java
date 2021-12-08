package com.marvel.marvel.dto;

import lombok.Data;
import java.util.List;
import java.util.Date;

@Data
public class UserDto {
  private String id;
  private List<DocumentDto> documents;
  private List<ClassEnrollmentDto> enrollments;
  private String name;
  private String email;
  private String phone;
  private String gender;
  private Date birthday;
  private String role;
}

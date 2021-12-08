package com.marvel.marvel.dto;

import lombok.Data;
import java.util.Date;


@Data
public class ClassEnrollmentDto {
  private String id;
  private Date date;
  private CourseClassDto course;
  private Integer test_1;
  private Integer test_2;
  private Integer assignment_1;
  private Integer assignment_2;
}

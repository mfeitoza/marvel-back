package com.marvel.marvel.dto;

import lombok.Data;
import java.util.Date;


@Data
public class ClassEnrollmentDto {
  private String id;
  private Date date;
  private CourseClassDto course;
}

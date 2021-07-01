package com.marvel.marvel.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ClassCourseDto {
  private String id;
  private String location;
  private Integer avaliablePlaces;
  private Date startDate;
  private Date endDate;
}

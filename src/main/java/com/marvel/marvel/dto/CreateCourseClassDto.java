package com.marvel.marvel.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CreateCourseClassDto {
  private String location;
  private Integer availablePlaces;
  private Date startDate;
  private Date endDate;
  private String courseId;
  private String professorId;
}

package com.marvel.marvel.dto;

import java.util.List;
import lombok.Data;

@Data
public class CreateCourseDto {
    private List<CourseDto> courses;
    private String name;
    private Integer workload;
    private String description;
    
}

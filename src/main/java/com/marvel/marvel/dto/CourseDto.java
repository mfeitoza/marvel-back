package com.marvel.marvel.dto;

import lombok.Data;
import java.util.List;

@Data
public class CourseDto {
    private String id;
    private String name;
    private String description;
    private Integer workload;
    private List<CourseClassDto> courses;
}

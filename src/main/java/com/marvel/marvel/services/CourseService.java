package com.marvel.marvel.services;

import com.marvel.marvel.entities.Course;
import com.marvel.marvel.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {
  
  @Autowired
  private CourseRepository courseRepository;
  
}

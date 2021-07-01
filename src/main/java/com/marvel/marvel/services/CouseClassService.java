package com.marvel.marvel.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.marvel.marvel.entities.CourseClass;
import com.marvel.marvel.repositories.CourseClassRepository;

@Service
public class CouseClassService {
  @Autowired
  private CourseClassRepository courseClassRepository;

  public List<CourseClass> findAll(){
    return courseClassRepository.findAll();
}
}

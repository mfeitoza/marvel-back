package com.marvel.marvel.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marvel.marvel.entities.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, String>  {

  List<Course> findAll();

  Optional<Course> findById(String id);

}

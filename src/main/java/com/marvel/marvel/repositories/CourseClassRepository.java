package com.marvel.marvel.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marvel.marvel.entities.CourseClass;

public interface CourseClassRepository extends PagingAndSortingRepository<CourseClass, String>  {

  List<CourseClass> findAll();

  Optional<CourseClass> findById(String id);

}

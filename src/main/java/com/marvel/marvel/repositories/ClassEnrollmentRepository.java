package com.marvel.marvel.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marvel.marvel.entities.ClassEnrollment;

public interface ClassEnrollmentRepository extends PagingAndSortingRepository<ClassEnrollment, String> {
  
  List<ClassEnrollment> findAll();

  Optional<ClassEnrollment> findById(String id);

  List<ClassEnrollment> findByUserId(String userId);
}

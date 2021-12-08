package com.marvel.marvel.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvel.marvel.entities.ClassEnrollment;
import com.marvel.marvel.repositories.ClassEnrollmentRepository;

@Service
public class ClassEnrollmentService {

  @Autowired
  private ClassEnrollmentRepository classEnrollmentRepository;

  public List<ClassEnrollment> findByUser(String userId) {
    return classEnrollmentRepository.findByUserId(userId);
  }

}

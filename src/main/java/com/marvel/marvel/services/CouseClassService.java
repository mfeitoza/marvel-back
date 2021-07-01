package com.marvel.marvel.services;

import java.util.List;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.marvel.marvel.dto.CreateCourseClassDto;
import com.marvel.marvel.entities.CourseClass;
import com.marvel.marvel.repositories.CourseClassRepository;

@Service
public class CouseClassService {
  @Autowired
  private CourseClassRepository courseClassRepository;

  public CourseClass create(String location, Integer availablePlaces, Date startDate, Date endDate,
      String courseId, String professorId) {
    CourseClass courseClass =
        new CourseClass(location, availablePlaces, startDate, endDate, courseId, professorId);
    courseClassRepository.save(courseClass);
    return courseClass;
  }

  public CourseClass create(CreateCourseClassDto newCourseClass) {
    CourseClass courseClass = new CourseClass(newCourseClass.getLocation(),
        newCourseClass.getAvailablePlaces(), newCourseClass.getStartDate(),
        newCourseClass.getEndDate(), newCourseClass.getCourseId(), newCourseClass.getProfessorId());
    courseClassRepository.save(courseClass);
    return courseClass;
  }

  public List<CourseClass> findAll() {
    return courseClassRepository.findAll();
  }

  public Optional<CourseClass> findById(String id) {
    return courseClassRepository.findById(id);
  }
}

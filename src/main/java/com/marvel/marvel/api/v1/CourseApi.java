package com.marvel.marvel.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import com.marvel.marvel.dto.CourseDto;
import com.marvel.marvel.dto.CreateCourseDto;
import com.marvel.marvel.entities.Course;
import com.marvel.marvel.services.CourseService;
import com.marvel.marvel.util.UtilModelMapper;

@RestController
public class CourseApi{

  @Autowired
  private CourseService courseService;
  
  @GetMapping("/courses")
  @ResponseBody
  public List<CourseDto> listCourses() {
    List<Course> courses = courseService.findAll();
    return UtilModelMapper.mapList(courses, CourseDto.class);
  }

  @PostMapping("/courses")
  @ResponseBody
  public CourseDto createCourse(@RequestBody CreateCourseDto newCourse) {
    Course course = courseService.create(newCourse);
    return UtilModelMapper.map(course, CourseDto.class);
  }

  @GetMapping("/courses/{id}")
  @ResponseBody
  public CourseDto getCourse(@PathVariable String id) {
    Optional<Course> course = courseService.findById(id);
    if (course.isPresent()) {
      return UtilModelMapper.map(course.get(), CourseDto.class);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
    }
  }
}

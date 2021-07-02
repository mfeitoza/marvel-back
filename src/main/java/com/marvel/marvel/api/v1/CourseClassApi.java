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
import com.marvel.marvel.dto.CourseClassDto;
import com.marvel.marvel.dto.CreateCourseClassDto;
import com.marvel.marvel.entities.CourseClass;
import com.marvel.marvel.services.CouseClassService;
import com.marvel.marvel.util.UtilModelMapper;

@RestController
public class CourseClassApi {

  @Autowired
  private CouseClassService courseClassService;

  @GetMapping("/classes")
  @ResponseBody
  public List<CourseClassDto> listCourses() {
    List<CourseClass> courses = courseClassService.findAll();
    return UtilModelMapper.mapList(courses, CourseClassDto.class);
  }

  @PostMapping("/classes")
  @ResponseBody
  public CourseClassDto createCourseClass(@RequestBody CreateCourseClassDto newCourseClass) {
    CourseClass courseClass = courseClassService.create(newCourseClass);
    return UtilModelMapper.map(courseClass, CourseClassDto.class);
  }
}

package com.marvel.marvel.services;

import java.util.List;
import java.util.Optional;
import com.marvel.marvel.dto.CreateCourseDto;
import com.marvel.marvel.entities.Course;
import com.marvel.marvel.repositories.CourseRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //coloco o AuthService tamb
    public Course create (String name, String description, Integer workload) // aqui eu preciso colocar um List<CourseClass>?
    {
        Course course = new Course(name, description, workload);
        courseRepository.save(course);
        return course;
    }
    public Course create (CreateCourseDto newCourse){
        Course course = new Course(newCourse.getName(), newCourse.getDescription(), newCourse.getWorkload());
        courseRepository.save(course);
        return course;
    }
    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public Optional<Course> findById(String id){
        return courseRepository.findById(id);
    }
}

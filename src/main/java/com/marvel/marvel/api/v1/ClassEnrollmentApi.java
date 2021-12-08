package com.marvel.marvel.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.marvel.marvel.dto.ClassEnrollmentDto;
import com.marvel.marvel.entities.ClassEnrollment;
import com.marvel.marvel.entities.User;
import com.marvel.marvel.services.ClassEnrollmentService;
import com.marvel.marvel.services.UserService;
import com.marvel.marvel.util.UtilModelMapper;

@RestController
public class ClassEnrollmentApi {

  @Autowired
  private ClassEnrollmentService classEnrollmentService;

  @Autowired
  private UserService userService;

  @GetMapping("/enrollments")
  @ResponseBody
  public List<ClassEnrollmentDto> listClassEnrollments(Principal principal) {
    String email = principal.getName();
    Optional<User> user = userService.findByEmail(email);
    if (user.isPresent()) {
      List<ClassEnrollment> enrollments = classEnrollmentService.findByUser(user.get().getId());
      System.out.println(user.get().getId());
      return UtilModelMapper.mapList(enrollments, ClassEnrollmentDto.class);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
  
}

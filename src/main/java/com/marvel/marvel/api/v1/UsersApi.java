package com.marvel.marvel.api.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import com.marvel.marvel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import com.marvel.marvel.dto.UserDto;
import com.marvel.marvel.dto.CreateUserDto;
import com.marvel.marvel.entities.User;
import com.marvel.marvel.util.UtilModelMapper;

@RestController
public class UsersApi {

  @Autowired
  private UserService userService;

  @PostMapping("/students")
  @ResponseBody
  public UserDto createStudent(@RequestBody CreateUserDto newUser) {
    User user = userService.createStudent(newUser);
    return UtilModelMapper.map(user, UserDto.class);
  }

  @PostMapping("/professors")
  @ResponseBody
  public UserDto createProfessor(@RequestBody CreateUserDto newUser) {
    User user = userService.createProfessor(newUser);
    return UtilModelMapper.map(user, UserDto.class);
  }

  @GetMapping("/users/{id}")
  @ResponseBody
  public UserDto getUser(@PathVariable String id) {
    Optional<User> user = userService.findById(id);
    if (user.isPresent()) {
      return UtilModelMapper.map(user.get(), UserDto.class);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }

  @GetMapping("/students")
  @ResponseBody
  public List<UserDto> listStudents() {
    List<User> users = userService.findAllStudents();
    return UtilModelMapper.mapList(users, UserDto.class);
  }

  @GetMapping("/professors")
  @ResponseBody
  public List<UserDto> listProfessors() {
    List<User> users = userService.findAllProfessors();
    return UtilModelMapper.mapList(users, UserDto.class);
  }

  @GetMapping("/user-info")
  @ResponseBody
  public UserDto userByToken(Principal principal) {
    String email = principal.getName();
    Optional<User> user = userService.findByEmail(email);
    if (user.isPresent()) {
      return UtilModelMapper.map(user.get(), UserDto.class);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
}

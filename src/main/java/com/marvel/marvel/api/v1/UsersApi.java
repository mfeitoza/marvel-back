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
  
  @GetMapping("/users")
  @ResponseBody
  public List<UserDto> listUsers() {
    List<User> users = userService.findAll();
    return UtilModelMapper.mapList(users, UserDto.class);
  }

  @PostMapping("/users")
  @ResponseBody
  public UserDto createUser(@RequestBody CreateUserDto newUser) {
    User user = userService.createStudent(newUser);
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
}

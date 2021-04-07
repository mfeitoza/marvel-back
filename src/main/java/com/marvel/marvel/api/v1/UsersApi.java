package com.marvel.marvel.api.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import com.marvel.marvel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
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
    User user = userService.create(newUser);
    return UtilModelMapper.map(user, UserDto.class);
  }
}

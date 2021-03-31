package com.marvel.marvel.api.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import com.marvel.marvel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.marvel.marvel.dto.UserDto;
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
}

package com.marvel.marvel.api.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(name = "/users")
public class UsersApi {
  
  @GetMapping
  @ResponseBody
  public  listUsers() {

  }
}

package com.marvel.marvel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.marvel.marvel.entities.User;
import com.marvel.marvel.entities.Document;
import com.marvel.marvel.repositories.UserRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private AuthService authService;

  public User create(String name, String email, String password, String phone, String gender,
  Date birthday, List<Document> documents) {
    User user = new User(name, email, authService.encodePassword(password), phone, gender, birthday, documents);
    userRepository.save(user);
    return user;
  }

  public User create(String name, String email, String password, String phone, String gender,
  Date birthday) {
    User user = new User(name, email, authService.encodePassword(password), phone, gender, birthday);
    userRepository.save(user);
    return user;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findById(String id) {
    return userRepository.findById(id);
  }
  
}

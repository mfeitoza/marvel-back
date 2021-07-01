package com.marvel.marvel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.marvel.marvel.entities.User;
import com.marvel.marvel.entities.RoleEnum;
import com.marvel.marvel.dto.CreateUserDto;
import com.marvel.marvel.entities.Document;
import com.marvel.marvel.repositories.UserRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthService authService;

  public User createStudent(String name, String email, String password, String phone, String gender,
      Date birthday, List<Document> documents) {
    User user = new User(name, email, authService.encodePassword(password), phone, gender, birthday,
        documents, RoleEnum.student);
    userRepository.save(user);
    return user;
  }

  public User createStudent(String name, String email, String password, String phone, String gender,
      Date birthday) {
    User user =
        new User(name, email, authService.encodePassword(password), phone, gender, birthday, RoleEnum.student);
    userRepository.save(user);
    return user;
  }

  public User createStudent(CreateUserDto newUser) {
    User user = new User(newUser.getName(), newUser.getEmail(),
        authService.encodePassword(newUser.getPassword()), newUser.getPhone(), newUser.getGender(),
        newUser.getBirthday(), RoleEnum.student);
    userRepository.save(user);
    return user;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public List<User> findAllStudents() {
    return userRepository.findByRole(RoleEnum.student.toString());
  }

  public List<User> findAllProfessors() {
    return userRepository.findByRole(RoleEnum.professor.toString());
  }

  public Optional<User> findById(String id) {
    return userRepository.findById(id);
  }

}

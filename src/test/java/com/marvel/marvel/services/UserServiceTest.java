package com.marvel.marvel.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.javafaker.Faker;
import com.marvel.marvel.entities.User;

@SpringBootTest
public class UserServiceTest {

  Faker faker = new Faker();

  @Autowired
  private UserService userService;

  @Test
  public void testCreateUser() throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date from = formatter.parse("01/01/1950");
    Date to = formatter.parse("31/12/2000");

    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String phone = faker.phoneNumber().cellPhone();
    String gender = faker.options().option("female", "male", "other");
    Date birthday = faker.date().between(from, to);

    User user = userService.create(name, email, password, phone, gender, birthday);
    assertEquals(name, user.getName());
    assertNotNull(user.getId());
  }
}

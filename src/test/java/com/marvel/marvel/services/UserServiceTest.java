package com.marvel.marvel.services;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.javafaker.Faker;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marvel.marvel.entities.Document;
import com.marvel.marvel.entities.User;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class UserServiceTest {

  Faker faker = new Faker();

  @Autowired
  private UserService userService;

  @Test
  public void testGetAllUsers() {
    List<User> users = userService.findAll();
    assertTrue((users.size() > 0));
  }

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

    User user = userService.createStudent(name, email, password, phone, gender, birthday);

    assertEquals(name, user.getName());
    assertNotEquals(password, user.getPassword());
    assertNotNull(user.getId());
  }

  @Test
  public void testCreateUserWithDocuments() throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date from = formatter.parse("01/01/1950");
    Date to = formatter.parse("31/12/2000");

    String name = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String phone = faker.phoneNumber().cellPhone();
    String gender = faker.options().option("female", "male", "other");
    Date birthday = faker.date().between(from, to);

    Document doc1 = new Document("ssn", faker.idNumber().ssnValid());
    Document doc2 = new Document("id", faker.idNumber().ssnValid());

    List<Document> documents = List.of(doc1, doc2);

    User user = userService.createStudent(name, email, password, phone, gender, birthday, documents);

    assertEquals(name, user.getName());
    assertNotEquals(password, user.getPassword());
    assertNotNull(user.getId());
    assertTrue(user.getDocuments().size() > 0);
  }
}
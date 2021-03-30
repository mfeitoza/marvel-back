package com.marvel.marvel.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;

@SpringBootTest
public class AuthServiceTest {

  @Autowired
  private AuthService authService;

  @Test
  public void testPasswordEncoding() {
    String rawPassword = UUID.randomUUID().toString().substring(0, 8);
    String encodedPassword = authService.encodePassword(rawPassword);
    assertFalse(rawPassword.equals(encodedPassword));
  }

  @Test
  public void testPasswordChecking() {
    String rawPassword = UUID.randomUUID().toString().substring(0, 8);
    String encodedPassword = authService.encodePassword(rawPassword);
    assertTrue(authService.checkPassword(rawPassword, encodedPassword));
  }
}

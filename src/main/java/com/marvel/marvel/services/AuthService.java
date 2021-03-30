package com.marvel.marvel.services;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.SecureRandom;

@Service
public class AuthService {
  private int strength = 10;
  private BCryptPasswordEncoder bCryptPasswordEncoder = 
      new BCryptPasswordEncoder(strength, new SecureRandom());

  public String encodePassword(String rawPassword) {
    return bCryptPasswordEncoder.encode(rawPassword);
  }

  public boolean checkPassword(String rawPassword, String encodedPassword) {
    return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
  }
}

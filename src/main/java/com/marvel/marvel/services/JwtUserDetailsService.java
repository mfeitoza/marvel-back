package com.marvel.marvel.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.marvel.marvel.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
  private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<com.marvel.marvel.entities.User> user = userRepository.findByEmail(email);
		
    if (user.isPresent()) {
      return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
    } else {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
	}
	
}

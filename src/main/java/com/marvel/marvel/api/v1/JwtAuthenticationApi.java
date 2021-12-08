package com.marvel.marvel.api.v1;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marvel.marvel.services.JwtUserDetailsService;
import com.marvel.marvel.services.UserService;
import com.marvel.marvel.util.UtilModelMapper;
import com.marvel.marvel.JwtTokenUtil;
import com.marvel.marvel.dto.LoginDto;
import com.marvel.marvel.dto.UserDto;
import com.marvel.marvel.entities.User;
import com.marvel.marvel.model.JwtRequest;
import com.marvel.marvel.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationApi {
  @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
  private UserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> login(@RequestBody LoginDto credentials) {
    Optional<User> user = userService.login(credentials);
    if (user.isPresent()) {
			String token = jwtTokenUtil.generateToken(user.get().getEmail());
			return ResponseEntity.ok(new JwtResponse(token));
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
}

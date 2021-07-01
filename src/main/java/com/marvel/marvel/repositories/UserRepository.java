package com.marvel.marvel.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.marvel.marvel.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {

  List<User> findAll();

  List<User> findByRole(String role);

  Optional<User> findByEmail(String email);

  Optional<User> findById(String id);

}

package com.shureck.repo;

import com.shureck.controllers.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   User findUserByLastName(String str);
}

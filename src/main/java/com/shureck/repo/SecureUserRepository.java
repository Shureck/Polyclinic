package com.shureck.repo;

import com.shureck.controllers.SecureUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecureUserRepository extends JpaRepository<SecureUser, Long> {
    SecureUser findByUsername(String username);
}

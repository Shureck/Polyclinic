package com.shureck.repo;

import com.shureck.controllers.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepos extends JpaRepository<Login, Long> {
    Login findLoginByLogin(String log);
}

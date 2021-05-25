package com.shureck.repo;

import com.shureck.controllers.Spec;
import com.shureck.controllers.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecRepository extends JpaRepository<Spec, Long> {
    Spec findBySpecialtys(String str);
    Spec findByDoctors(String str);
}

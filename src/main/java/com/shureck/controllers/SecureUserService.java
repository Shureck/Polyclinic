package com.shureck.controllers;

import com.shureck.repo.RoleRepository;
import com.shureck.repo.SecureUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SecureUserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    SecureUserRepository secureUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecureUser secureUser = secureUserRepository.findByUsername(username);

        if (secureUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return secureUser;
    }

    public SecureUser findUserById(Long userId) {
        Optional<SecureUser> userFromDb = secureUserRepository.findById(userId);
        return userFromDb.orElse(new SecureUser());
    }

    public List<SecureUser> allUsers() {
        return secureUserRepository.findAll();
    }

    public boolean saveUser(SecureUser secureUser) {
        SecureUser userFromDB = secureUserRepository.findByUsername(secureUser.getUsername());

        if (userFromDB != null) {
            return false;
        }

        secureUser.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        secureUser.setPassword(bCryptPasswordEncoder.encode(secureUser.getPassword()));
        secureUserRepository.save(secureUser);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (secureUserRepository.findById(userId).isPresent()) {
            secureUserRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
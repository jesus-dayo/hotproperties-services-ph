package com.hotproperties.web.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotproperties.web.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}

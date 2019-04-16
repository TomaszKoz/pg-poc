package com.archicode.playground.poc.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}

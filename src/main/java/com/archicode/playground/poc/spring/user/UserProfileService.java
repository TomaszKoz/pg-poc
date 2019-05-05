package com.archicode.playground.poc.spring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileService {

    private final UserProfileRepository repository;

    public void save(UserProfile userProfile) {
        repository.save(userProfile);
    }

    public UserProfile findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public long count() {
        return repository.count();
    }

}

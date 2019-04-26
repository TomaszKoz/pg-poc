package com.archicode.playground.poc.spring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfile createExampleUserProfile() {
        UserProfile profile = new UserProfile();
        profile.setCompany("Creative Code Inc.");
        profile.setUsername("michael23");
        profile.setFirstName("Mike");
        profile.setLastName("Andrew");
        profile.setEmail("mike.andrew@mail.com");
        profile.setAddress("Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09");
        profile.setCity("Toronto");
        profile.setCountry("Canada");
        profile.setAboutMe("Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.");

        return repository.save(profile);
    }

    public void save(UserProfile userProfile) {
        repository.save(userProfile);
    }

    public List<UserProfile> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

}

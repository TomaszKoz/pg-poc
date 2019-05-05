package com.archicode.playground.poc.spring.mock;

import com.archicode.playground.poc.logger.AppLogger;
import com.archicode.playground.poc.spring.user.UserProfile;
import com.archicode.playground.poc.spring.user.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Tomasz Kozlowski (created on 03.05.2019)
 */
@Component
@AllArgsConstructor
public class DataMockLoader implements CommandLineRunner {

    private final UserProfileService userProfileService;

    @Override
    public void run(String... args) throws Exception {
        if (userProfileService.count() == 0) {
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
            userProfileService.save(profile);
            AppLogger.info(String.format("User profile for %s has been created", profile.getUsername()));
        }
    }

}

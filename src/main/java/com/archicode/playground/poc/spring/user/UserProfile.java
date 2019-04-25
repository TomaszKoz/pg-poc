package com.archicode.playground.poc.spring.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
@Entity
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String company;
    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String postalCode;
    @Column
    private String aboutMe;

    @Override
    public String toString() {
        return String.format("%s %s [id: %s]", firstName, lastName, id);
    }

}

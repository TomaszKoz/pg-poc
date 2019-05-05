package com.archicode.playground.poc.spring.user;

import com.archicode.playground.poc.spring.converters.StringConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
@Entity
@Getter
public class UserProfile {

    @Id
    @GeneratedValue
    @Setter
    private Long id;

    @Column(name = "COMPANY")
    @Convert(converter = StringConverter.class)
    private StringProperty companyProperty = new SimpleStringProperty();

    @Column(name = "USERNAME")
    @Convert(converter = StringConverter.class)
    private StringProperty usernameProperty = new SimpleStringProperty();

    @Column(name = "FIRST_NAME")
    @Convert(converter = StringConverter.class)
    private StringProperty firstNameProperty = new SimpleStringProperty();

    @Column(name = "LAST_NAME")
    @Convert(converter = StringConverter.class)
    private StringProperty lastNameProperty = new SimpleStringProperty();

    @Column(name = "EMAIL")
    @Convert(converter = StringConverter.class)
    private StringProperty emailProperty = new SimpleStringProperty();

    @Column(name = "ADDRESS")
    @Convert(converter = StringConverter.class)
    private StringProperty addressProperty = new SimpleStringProperty();

    @Column(name = "CITY")
    @Convert(converter = StringConverter.class)
    private StringProperty cityProperty = new SimpleStringProperty();

    @Column(name = "COUNTRY")
    @Convert(converter = StringConverter.class)
    private StringProperty countryProperty = new SimpleStringProperty();

    @Column(name = "POSTAL_CODE")
    @Convert(converter = StringConverter.class)
    private StringProperty postalCodeProperty = new SimpleStringProperty();

    @Column(name = "ABOUT_ME")
    @Convert(converter = StringConverter.class)
    private StringProperty aboutMeProperty = new SimpleStringProperty();

    public String getCompany() {
        return companyProperty.get();
    }

    public void setCompany(String company) {
        this.companyProperty.set(company);
    }

    public String getUsername() {
        return usernameProperty.get();
    }

    public void setUsername(String username) {
        this.usernameProperty.set(username);
    }

    public String getFirstName() {
        return firstNameProperty.get();
    }

    public void setFirstName(String firstName) {
        this.firstNameProperty.set(firstName);
    }

    public String getLastName() {
        return lastNameProperty.get();
    }

    public void setLastName(String lastName) {
        this.lastNameProperty.set(lastName);
    }

    public String getEmail() {
        return emailProperty.get();
    }

    public void setEmail(String email) {
        this.emailProperty.set(email);
    }

    public String getAddress() {
        return addressProperty.get();
    }

    public void setAddress(String address) {
        this.addressProperty.set(address);
    }

    public String getCity() {
        return cityProperty.get();
    }

    public void setCity(String city) {
        this.cityProperty.set(city);
    }

    public String getCountry() {
        return countryProperty.get();
    }

    public void setCountry(String country) {
        this.countryProperty.set(country);
    }

    public String getPostalCode() {
        return postalCodeProperty.get();
    }

    public void setPostalCode(String postalCode) {
        this.postalCodeProperty.set(postalCode);
    }

    public String getAboutMe() {
        return aboutMeProperty.get();
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMeProperty.set(aboutMe);
    }

    @Override
    public String toString() {
        return String.format("%s %s [id: %s]", getFirstName(), getLastName(), id);
    }

}

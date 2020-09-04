package com.isa.morswiny.users;

import com.isa.morswiny.events.Event;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "EventsUsers")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "Name", unique = false, nullable = true)
    private String name;

    @Column(name = "Surname", unique = false, nullable = true)
    private String surname;

    @Column(name = "Login", unique = false, nullable = true)
    private String login;

    @Column(name = "Email", unique = false, nullable = true)
    private String email;

    @Column(name = "Password", unique = false, nullable = true)
    private String password;

    @Column(name = "Gender", unique = false, nullable = true)
    private String userGender;

    @Column(name = "Nationality", unique = false, nullable = true)
    private String userNationality;

    @Column(name = "UserType", unique = false, nullable = true)
    private String userType;

    @Column(name = "Birthday", unique = false, nullable = true)
    private LocalDate birthday;

    @Column(name = "RegistrationTime", unique = false, nullable = true)
    private LocalDateTime registrationTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userGender, user.userGender) &&
                Objects.equals(userNationality, user.userNationality) &&
                Objects.equals(userType, user.userType) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(registrationTime, user.registrationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, email, password, userGender, userNationality, userType, birthday, registrationTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userGender=" + userGender +
                ", userNationality=" + userNationality +
                ", userType=" + userType +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /*public List<Event> getFavourites() {

        return favourites;
    }

    public void setFavourites(List<Event> favourites) {
        this.favourites = favourites;
    }

    public List<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(List<Event> myEvents) {
        this.myEvents = myEvents;
    }


     */


    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public void setUserNationality(String userNationality) {
        this.userNationality = userNationality;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}

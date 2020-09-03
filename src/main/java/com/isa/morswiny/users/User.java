package com.isa.morswiny.users;

import com.isa.morswiny.events.Event;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class User {


    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private String userGender;
    private String userNationality;
    private UserType userType;
    private LocalDate birthday;
    private List<Event> favourites = new ArrayList<>();
    private List<Event> myEvents = new ArrayList<>();
    private BufferedImage myPicture;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userGender, user.userGender) &&
                Objects.equals(userNationality, user.userNationality) &&
                userType == user.userType &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(favourites, user.favourites) &&
                Objects.equals(myEvents, user.myEvents) &&
                Objects.equals(myPicture, user.myPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, login, email, password, userGender, userNationality, userType, birthday, favourites, myEvents, myPicture);
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Event> getFavourites() {
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

    public BufferedImage getMyPicture() {
        return myPicture;
    }

    public void setMyPicture(BufferedImage myPicture) {
        this.myPicture = myPicture;
    }

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
}

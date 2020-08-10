package com.isa.morswiny.users;

import com.isa.morswiny.events.Event;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Integer ID;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private UserTypes userTypes;
    private LocalDateTime birthday;
    private List<Event> favourites = new ArrayList<>();
    private List<Event> myEvents = new ArrayList<>();
    private BufferedImage myPicture;

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", userTypes=" + userTypes +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return ID.equals(user.ID) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                login.equals(user.login) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                userTypes == user.userTypes &&
                birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, surname, login, email, password, userTypes, birthday);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public UserTypes getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserTypes userTypes) {
        this.userTypes = userTypes;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
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
}

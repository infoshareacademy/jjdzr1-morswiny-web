package com.isa.morswiny.dto;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserType;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private UserType userType;
    private List<Event> favourites;

    public UserDto () {

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

    public List<Event> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Event> favourites) {
        this.favourites = favourites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                getUserType() == user.getUserType() &&
                Objects.equals(getFavourites(), user.getFavourites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getLogin(), getEmail(), getPassword(), getUserType(), getFavourites());
    }
}

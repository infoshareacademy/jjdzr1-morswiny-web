package com.isa.morswiny.users;


import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EventsUsers")
public class UserHiber {

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
    private UserType userType;

    @Column(name = "Birthday", unique = false, nullable = true)
    private LocalDate birthday;

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Column(name = "RegistrationTime", unique = false, nullable = true)
    private LocalDateTime registrationTime;

    @Column(name = "Picture", unique = false, nullable = true)
    private Image myPicture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    /*
    public BufferedImage getMyPicture() {
        return myPicture;
    }

    public void setMyPicture(BufferedImage myPicture) {
        this.myPicture = myPicture;
    }

     */
}

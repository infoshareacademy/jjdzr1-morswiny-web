package com.isa.morswiny.servlets;


import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserType;
import com.isa.morswiny.usersDao.UserConnectionHiber;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/add-user-hiber")

public class AddUserServletHiber extends HttpServlet {

    public AddUserServletHiber() {
        super();
    }

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User userHiber1 = new User();
        userHiber1.setName("Przem2");
        userHiber1.setSurname("Ziel");
        userHiber1.setLogin("pzx");
        userHiber1.setEmail("pzx1@com.pl");
        userHiber1.setPassword("przemek");
        userHiber1.setUserGender("MALE");
        userHiber1.setUserNationality("Poland");
        userHiber1.setUserType("ADMIN");
        userHiber1.setBirthday(LocalDate.parse("1999-01-01"));
        userHiber1.setRegistrationTime(LocalDateTime.now());

        Session sessionHiber = UserConnectionHiber.getSession();
        sessionHiber.beginTransaction();
        sessionHiber.save(userHiber1);
        sessionHiber.getTransaction().commit();
        UserConnectionHiber.close();

        req.getRequestDispatcher("/thank-you").forward(req,resp);

    }


}
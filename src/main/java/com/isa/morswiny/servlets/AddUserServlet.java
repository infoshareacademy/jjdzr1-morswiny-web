package com.isa.morswiny.servlets;

import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserGender;
import com.isa.morswiny.users.UserNationality;
import com.isa.morswiny.users.UserType;
import com.isa.morswiny.usersDao.UserDataManagement;
import com.isa.morswiny.usersDao.UserRegistrationDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    private UserRegistrationDao userRegistrationDao = new UserRegistrationDao();


    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("user", new User());
        RequestDispatcher rd = req.getRequestDispatcher("create-account.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("signupName");
        String surname = req.getParameter("signupSurname");
        String login = req.getParameter("signupLogin");
        String email = req.getParameter("signupEmail");
        String password = req.getParameter("signupPassword");
        String userGender = req.getParameter("signupGender");
        String userNationality = req.getParameter("country");
        String userType = req.getParameter("userType");
        String birthday = req.getParameter("signupBirthday");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserGender(userGender);
        user.setUserNationality(userNationality);
        user.setUserType(UserType.STANDARD_USER);
        user.setBirthday(LocalDate.parse(birthday));

        try {
            userRegistrationDao.registerUser(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
resp.sendRedirect("thank-you");
    }

}


/*
User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setUserType(UserType.STANDARD_USER);
        user.setBirthday(LocalDate.parse("birthday"));

        UserDataManagement userDataManagement = new UserDataManagement();
        userDataManagement.addUser(user);

        PrintWriter pw = resp.getWriter();
        pw.write(userDataManagement.getUsersSet().size());
 */
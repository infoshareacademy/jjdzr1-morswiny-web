package com.isa.morswiny.servlets;


import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserType;
import com.isa.morswiny.usersDao.UserConnectionHiber;
import freemarker.template.Template;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@WebServlet("/add-user-hiber")
public class AddUserServletHiber extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "create-account.ftlh";

    @Inject
    private TemplateProvider templateProvider;

    public AddUserServletHiber() {
        super();
    }

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

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
        String userType = req.getParameter("signUserType");
        String birthday = req.getParameter("signupBirthday");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserGender(userGender);
        user.setUserNationality(userNationality);
        user.setUserType(userType);
        user.setBirthday(LocalDate.parse(birthday));

        Session sessionHiber = UserConnectionHiber.getSession();
        sessionHiber.beginTransaction();
        sessionHiber.save(user);
        sessionHiber.getTransaction().commit();
        UserConnectionHiber.close();

        req.getRequestDispatcher("/thank-you").forward(req,resp);

    }

}

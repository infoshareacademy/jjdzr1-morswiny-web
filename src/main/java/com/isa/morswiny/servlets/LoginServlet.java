package com.isa.morswiny.servlets;


import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "login";

    @Inject
    EventCRUDRepositoryInterface userCRUDRepositoryInterface;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();


        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> map = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        String login = req.getParameter("email");
        int password = req.getParameter("password").hashCode();

        if (login.equals("kuba")) {
            req.getSession().setAttribute("logged", "userLogin");
            resp.sendRedirect("/main-page");
        } else {
            resp.sendRedirect("HTML/login-failed.html");
        }

        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }

    }

    private boolean ifUserExists(String email){
        return false;
    }

    private void logIn(String email, int Password){

    }


//    private Boolean findUser(String login, String passsword){
//        userCRUDRepositoryInterface.getUser()
//
//    }
}

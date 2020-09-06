package com.isa.morswiny.servlets;


import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.users.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
@WebServlet("/thank-you")
public class ThankYouServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "thank-you.ftlh";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String,Object> model = new HashMap<>();

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }
}
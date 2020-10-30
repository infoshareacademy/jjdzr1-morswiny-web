package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.Dao.UserDao;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.repository.EventRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/favourite")
public class AddFavouriteServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "favourites";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventDao eventDao;

    @Inject
    private EventRepository eventRepository;

    @Inject
    private UserDao userDao;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        String idEvent = req.getParameter("idEvent");
        writer.println(idEvent);

        Map<String, Object> map = new HashMap<>();


        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();

        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            map.put("logged", req.getSession().getAttribute("logged"));
        }

    }
}

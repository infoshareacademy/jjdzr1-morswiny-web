package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.eventsDao.EventSearchRepositoryInterface;
import com.isa.morswiny.web.TemplateProvider;
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
import java.util.*;

import static java.util.stream.Collectors.toList;

@WebServlet("/search-events")
public class SearchEventsServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger(AllEventsListServlet.class);
    private static final String TEMPLATE_NAME = "searchEvents";
    private String userQuery;
    private Map<String, Object> model = new HashMap<>();

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;
    @Inject
    TemplateProvider templateProvider;

    @Inject
    EventSearchRepositoryInterface eventSearchRepositoryInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter writer = resp.getWriter();
//        resp.setContentType("text/html;charset=UTF-8");
//        writer.println("Welcome to single event page");
        userQuery = req.getParameter("search");


        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        setModel();
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }

//        try {
//            writer.println(eventSearchRepositoryInterface.searchByString(userQuery));
//        } catch (NullPointerException e) {
//            writer.println("Event not found");
//        }
    }

    private List<Event> setListOfQueriedEvents() {
        return eventSearchRepositoryInterface.searchByString(userQuery);
    }

    private void setModel() {
        if (model == null || model.isEmpty()) {
            model.put("listOfQueriedEvents", setListOfQueriedEvents());
        }
    }


}

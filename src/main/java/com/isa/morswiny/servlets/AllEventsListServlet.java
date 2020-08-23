package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepository;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.repository.JsonEventDataLoad;
import com.isa.morswiny.users.User;
import com.isa.morswiny.web.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/event-list")
public class AllEventsListServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger(AllEventsListServlet.class);
    private static final String TEMPLATE_NAME = "allEvents";
    private Map<String, Object> model = new HashMap<>();
    private List<Event> listOfMainEvents = new ArrayList<>();

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        setModel();
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }

    }

    private void setModel() {
        if (model == null || model.isEmpty()) {
            model.put("listOfMainEvents", setListOfMainEvents());
        }
    }

    private List<Event> setListOfMainEvents() {
        List<Event> listOfAllEvents = eventCRUDRepositoryInterface.getAllEventsList();
        for (int i = 0; i < 3; i++) {
            listOfMainEvents.add(listOfAllEvents.get(i));
        }
        return listOfMainEvents;
    }


}



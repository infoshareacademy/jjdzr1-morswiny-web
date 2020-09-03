package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.events.EventURL;
import com.isa.morswiny.events.Organizer;
import com.isa.morswiny.events.Place;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@WebServlet("/edit-event")
public class EditEventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "editEvent.ftlh";

    @Inject
    private EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Map<String, Object> map = new HashMap<>();
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            Event event = eventCRUDRepositoryInterface.getEventByID(id);
            map.put("event", event);
        } catch (NullPointerException e) {
            writer.println("Event not found");
        }

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Integer id = Integer.parseInt(req.getParameter("id"));
        Event event = eventCRUDRepositoryInterface.getEventByID(id);

        event.setName(req.getParameter("eventName"));

        Place place = new Place();
        place.setName(req.getParameter("eventPlace"));
        event.setPlace(place);

        Organizer organizer = new Organizer();
        organizer.setDesignation(req.getParameter("organizer"));
        event.setOrganizer(organizer);

        EventURL url = new EventURL();
        url.setWww(req.getParameter("eventURL"));
        event.setUrls(url);

        event.setStartDate(req.getParameter("startDate"));
        event.setEndDate(req.getParameter("endDate"));
        event.setDescLong(req.getParameter("description"));

        eventCRUDRepositoryInterface.updateEvent(event);

        Map<String, Object> map = new HashMap<>();
        map.put("event", event);

        resp.sendRedirect("/single-event");

//        Template template = templateProvider.createTemplate(
//                getServletContext(), TEMPLATE_NAME);
//        try {
//            template.process(map, writer);
//        } catch (TemplateException e) {
//            STDOUT.error("Error while processing template: ", e);
//        }
    }
}



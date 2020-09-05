package com.isa.morswiny.servlets;

import com.isa.morswiny.events.*;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.parsers.DateTimeParser;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@WebServlet("/add-event")
public class AddEventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "addEvent.ftlh";


    @Inject
    private EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

    @Inject
    private DateTimeParser dateTimeParser;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> map = new HashMap<>();

        Template template = templateProvider.createTemplate(
                getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Event event = new Event();
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

        event.setStartDateLDT(dateTimeParser.setDateFormat(event.getStartDate()));
        event.setEndDateLDT(dateTimeParser.setDateFormat(event.getEndDate()));

        event.setDescLong(req.getParameter("description"));


        event.setAttachments(new Attachment[0]);
       //event.getAttachments()[0].setFileName(req.getParameter("attachment"));

        Ticket ticket = new Ticket();
        ticket.setType(req.getParameter("ticket"));
        event.setTickets(ticket);

        event.setCategoryId(req.getParameter("categoryId"));
        event.setActive(Integer.valueOf(req.getParameter("active")));


        if (null == event.getId()) {
            //TODO to be deleted
            event.setId(eventCRUDRepositoryInterface.getNextID());
            eventCRUDRepositoryInterface.createEvent(event);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("event", event);

        System.out.println(map);

        resp.sendRedirect("/new-event-created");
    }
}


package com.isa.morswiny.servlets;

import com.isa.morswiny.cdi.EventDao;
import com.isa.morswiny.events.Event;
import com.isa.morswiny.events.EventURL;
import com.isa.morswiny.events.Organizer;
import com.isa.morswiny.events.Place;
import com.isa.morswiny.eventsDao.EventCRUDRepository;
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
    private EventDao eventDao;

    @Inject
    private TemplateProvider templateProvider;

    Event event = new Event();
    EventCRUDRepository eventRepository = new EventCRUDRepository();

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

        Map<String, String[]> eventsMap = req.getParameterMap();
        eventDao.createEvent(eventsMap);

        Place place = new Place();
        place.setName(req.getParameter("eventPlace"));
        Organizer organizer = new Organizer();
        organizer.setDesignation(req.getParameter("organizer"));
        EventURL url = new EventURL();
        url.setWww(req.getParameter("eventURL"));

        event.setName(req.getParameter("eventName"));
        event.setPlace(place);
        event.setOrganizer(organizer);
        event.setUrls(url);
        event.setStartDateLDT(eventDao.setDateFormat(req.getParameter("startDate")));
        event.setEndDateLDT(eventDao.setDateFormat(req.getParameter("endDate")));
        event.setDescLong(req.getParameter("description"));
//        event.getAttachments()[0].setFileName(req.getParameter("attachment"));

        if (event.getId().equals(null)) {
            //TODO to be deleted
            event.setId(new EventCRUDRepository().getNextID());
            eventRepository.createEvent(event);
        } else {
            event = eventRepository.getEventByID(event.getId());
            eventRepository.updateEvent(event);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("event", event);

        Template template = templateProvider.createTemplate(
                getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }

    }
}


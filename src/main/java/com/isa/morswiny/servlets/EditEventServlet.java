package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepository;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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

        Integer id = Integer.parseInt(req.getParameter("id"));
        Event event = eventCRUDRepositoryInterface.getEventByID(id);

        event.setName(req.getParameter("eventName"));
        event.getPlace().setName(req.getParameter("eventPlace"));
        event.getOrganizer().setDesignation(req.getParameter("organizer"));
        event.getUrls().setWww(req.getParameter("url"));
        event.setStartDateLDT(LocalDateTime.parse(req.getParameter("start date")));
        event.setEndDateLDT(LocalDateTime.parse(req.getParameter("end date")));
        event.setDescLong(req.getParameter("description"));
        event.getAttachments()[0].setFileName(req.getParameter("attachment"));

        if (event.getId() == null) {
            //TODO to be deleted
            event.setId(new EventCRUDRepository().getNextID());
            eventCRUDRepositoryInterface.createEvent(event);
        } else {
            event = eventCRUDRepositoryInterface.getEventByID(event.getId());
            eventCRUDRepositoryInterface.updateEvent(event);
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


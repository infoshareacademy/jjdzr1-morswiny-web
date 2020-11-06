package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.model.Event;

import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.repository.EventRepository;
import com.isa.morswiny.services.EventService;
import com.isa.morswiny.services.ServletService;
import com.isa.morswiny.services.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/main-page")
public class AllEventsListServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger(AllEventsListServlet.class);
    private static final String TEMPLATE_NAME = "allEvents";
    private Map<String, Object> model = new HashMap<>();

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private EventService eventService;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        addAdmin();
        setModel();

        model.remove("logged");
        model.remove("admin");
        ServletService.sessionValidation(req, model);

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }
    }

    private void setModel() {
        model.put("listOfMainEvents", setListOfMainEvents(3));

    }

    private List<EventDto> setListOfMainEvents(int numOfEventsToSet) {

        return eventService.findLatestEvents(numOfEventsToSet);
    }

    private void addAdmin() {
        if (userService.getByEmail("admin@morswiny.pl") == null) {
            userService.createAdmin();
        }
    }
}



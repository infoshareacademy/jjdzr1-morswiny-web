package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;

import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
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
import java.util.*;

import static java.util.stream.Collectors.toList;


@WebServlet("/main-page")
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
        int numOfAllEvents = listOfAllEvents.size();
        int numOfMainEvents = returnNumberOfMainEvents(listOfAllEvents);

        listOfMainEvents = listOfAllEvents.stream()
                .sorted(Comparator.comparing(Event::getStartDateLDT))
                .skip(numOfAllEvents - numOfMainEvents)
                .collect(toList());

        return listOfMainEvents;
    }
    private int returnNumberOfMainEvents(List list){
        return Math.min(list.size(), 3);
    }
}



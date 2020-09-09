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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search-events-beta")
public class SearchEventsServletBeta extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger(AllEventsListServlet.class);
    private static final String TEMPLATE_NAME = "searchEventsBeta";

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;
    @Inject
    TemplateProvider templateProvider;

    @Inject
    EventSearchRepositoryInterface eventSearchRepositoryInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        final Map model = new HashMap();
        final String userQuery = req.getParameter("search");

        initModel(model, userQuery);
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }
    }

    private void initModel(Map model, String query) {
        model.put("userQuery", query);
        model.put("listOfQueriedEvents", setListOfQueriedEvents(query));
    }

    private List<Event> setListOfQueriedEvents(String userQuery) {
        return eventSearchRepositoryInterface.searchByString(userQuery);
    }


}

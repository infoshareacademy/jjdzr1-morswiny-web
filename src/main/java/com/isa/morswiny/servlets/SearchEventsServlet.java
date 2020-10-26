package com.isa.morswiny.servlets;

import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.eventsDao.EventDao;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.eventsDao.EventSearchRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.repository.EventRepository;
import com.isa.morswiny.services.EventService;
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

    @Inject
    EventRepository eventRepository;

    @Inject
    private EventService eventService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Integer limit = 20;
        String page = req.getParameter("page");
        Integer count = 5; //ilosc wszystkich eventow w bazie podxzielonych przez limit

        if(page==null){
            page = "0";
        }

        Integer pageInt = Integer.parseInt(page);

        final Map model = new HashMap();

        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            model.put("logged", req.getSession().getAttribute("logged"));
        }

        String userQuery = req.getParameter("search");

        initModel(model, userQuery,limit, pageInt, count);
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }
    }

    private void initModel(Map model, String query,Integer limit, Integer page, Integer count) {
        model.put("userQuery", query);
        model.put("listOfQueriedEvents", setListOfQueriedEvents(query));
        model.put("limit",limit);
        model.put("page",page);
        model.put("count",count);
    }

    private List<EventDto> setListOfQueriedEvents(String userQuery) {
        //return eventSearchRepositoryInterface.searchByString(userQuery); //start i limit
//        return  eventDao.findEventsByString(userQuery);

        return eventService.findByFreeText(userQuery);
    }


}

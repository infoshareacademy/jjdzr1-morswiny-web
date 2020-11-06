package com.isa.morswiny.servlets;

import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventService;
import com.isa.morswiny.services.FavouritesService;
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

    private static final Logger STDOUT = LoggerFactory.getLogger(SearchEventsServlet.class);
    private static final String TEMPLATE_NAME = "searchEvents";
    private Map<String, Object> model = new HashMap<>();

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private FavouritesService favouritesService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Integer limit = 20;
        String page = req.getParameter("page");
        Integer count = 5; //ilosc wszystkich eventow w bazie podxzielonych przez limit

        if(page==null){
            page = "0";
        }

        Integer pageInt = Integer.parseInt(page);

        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            model.put("logged", req.getSession().getAttribute("logged"));
        }

        String email = (String) req.getSession().getAttribute("logged");
        int userId = getUserId(email);


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
        return eventService.findByFreeText(userQuery);
    }

    private int getUserId(String email){
        UserDto user = favouritesService.getUserByEmail(email);
        return user.getId();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> map = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);


        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            map.put("logged", req.getSession().getAttribute("logged"));
        }

        String email = (String) req.getSession().getAttribute("logged");
        int userId = getUserId(email);

        if(isEventInFavouritesAlready(userId,eventDto){
            map.put("eventExist",eventDto);
        }else if addEventToFavourites(eventDto, userId){
            map.put("success","success");
        }else{
            map.put("error","error");
        }



        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }

    }

    private boolean addEventToFavourites(EventDto eventDto,Integer userId){
        if(isEventInFavouritesAlready(userId,eventDto)){
            favouritesService.save(eventDto);
            return true;
        }else{
            return false;
        }
    }

    private boolean isEventInFavouritesAlready(Integer userId, EventDto event){
        Set<EventDto> favourites = setListOfFavouritesEventsForUser(userId);
        return favourites.contains(event);
    }

    private Set<EventDto> setListOfFavouritesEventsForUser(Integer userId){
        return favouritesService.getAllFavouritesForUser(userId);
    }





}

package com.isa.morswiny.servlets;

import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventService;
import com.isa.morswiny.services.FavouritesService;
import com.isa.morswiny.services.UserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ApplicationScoped //?
@WebServlet("/favourites-list")
public class FavouritesUserServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "favouritesUserList";
    private Map<String, Object> model = new HashMap<>();


    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private FavouritesService favouritesService;

    @Inject
    UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            model.put("logged", req.getSession().getAttribute("logged"));
        }

        //metoda w dao wyszkujaca po mailu usera
        //pozniej z req.getsesstion atrybut przypisac do stringa
        //dodac metode w servlecie wyszukuja po emailu i zwracajaca id





        Integer count = 5;

        String id = req.getParameter("userId");
        Integer userId = Integer.parseInt(id);

        initModel(model, userId, count);
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);


        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: " + template.getName(), e);
        }
    }

    private void initModel(Map model, Integer userId, Integer count) {
        model.put("listOfFavourites", setListOfFavouritesEventsForUser(userId));
        model.put("count",count);
    }

    private List<EventDto> setListOfFavouritesEventsForUser(Integer userId){
        return favouritesService.getAllFavouritesForUser(userId);
    }

    private int getUserId(String email){
        favouritesService.
    }

}

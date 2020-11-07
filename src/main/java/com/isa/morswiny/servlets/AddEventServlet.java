package com.isa.morswiny.servlets;

import com.isa.morswiny.Dao.EventCRUDRepositoryInterface;
import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.OrganizerDto;
import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.parsers.DateTimeParser;
import com.isa.morswiny.model.*;
import com.isa.morswiny.services.OrganizerService;
import com.isa.morswiny.services.ServletService;
import com.isa.morswiny.services.EventService;
import freemarker.template.*;
import org.hibernate.id.UUIDGenerationStrategy;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
@WebServlet("/add-event")
public class AddEventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "addEvent";


    @Inject
    private EventService eventService;

    @Inject
    private OrganizerService organizerService;

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

        ServletService.sessionValidation(req, map);

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

        Map<String, Object> map = new HashMap<>();
        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);

        String eventName = req.getParameter("eventName");
        String active = req.getParameter("active");
        String placeId = req.getParameter("placeId");
        String organizerDesignation = req.getParameter("organizerDesignation");
        String organizerId = req.getParameter("organizerId");

        //String organizer = req.getParameter("organizer");

        String url = req.getParameter("url");
        String startDate = req.getParameter("startDate");
        String startDateLDT = req.getParameter("startDateLDT");
        String endDate = req.getParameter("endDate");
        String endDateLDT = req.getParameter("endDateLDT");
        Random r = new Random();
        int idRandom = r.nextInt();
        String id = Integer.toString(idRandom);
                String description = req.getParameter("description");
        String categoryId = req.getParameter("categoryId");
        addOrganizer(createOrganizer(organizerDesignation,organizerId));
        addEvent(createEvent(eventName, active, placeId, url, startDate, startDateLDT,
                endDate, endDateLDT, id, description, categoryId));
        map.put("event", "OK");
        resp.sendRedirect("/new-event-created");

    }
        /*
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


         */
        private EventDto createEvent (String eventName, String active, String placeId, String url,
                String startDate, String startDateLDT, String endDate, String endDateLDT, String id,
                                      String description, String categoryId){

            EventDto eventDto = new EventDto();
            eventDto.setName(eventName);
            eventDto.setActive(Integer.valueOf(active));
            eventDto.setPlace(eventDto.getPlace());
            eventDto.setUrls(eventDto.getUrls());
            eventDto.setStartDate(startDate);
            eventDto.setStartDateLDT(String.valueOf(dateTimeParser.setDateFormat(startDate)));
            eventDto.setEndDate(endDate);
            eventDto.setEndDateLDT(String.valueOf(dateTimeParser.setDateFormat(endDate)));
            eventDto.setId(Integer.valueOf(id));
            eventDto.setDescLong(description);
            eventDto.setCategoryId(categoryId);
            return eventDto;

        }

        private OrganizerDto createOrganizer (String organizerDesignation, String organizerId) {
            OrganizerDto organizerDto = new OrganizerDto();
            organizerDto.setDesignation(organizerDesignation);
            organizerDto.setId(organizerId);
return organizerDto;
        }



/*
    private boolean isEventAdded (Integer eventId) {
        return eventDao.findByJsonId(eventId) != null;
    }

*/
        private boolean addEvent (EventDto eventDto){
            eventService.saveEvent(eventDto);
            return true;
        }


        private boolean addOrganizer (OrganizerDto organizerDto) {
organizerService.saveOrganizer(organizerDto);
return true;
   }



    }
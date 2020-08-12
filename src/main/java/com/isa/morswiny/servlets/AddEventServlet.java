package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/add-event")
public class AddEventServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("event", new Event());
        RequestDispatcher rd = req.getRequestDispatcher("event");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Event event = new Event();
        event.setId(new EventCRUDRepository().getNextID());
        event.setName(req.getParameter("name"));
        event.getPlace().setName(req.getParameter("place name"));
        event.setStartDateLDT(LocalDateTime.parse(req.getParameter("start date")));
        event.setEndDateLDT(LocalDateTime.parse(req.getParameter("end date")));
        event.setDescLong(req.getParameter("description"));

        EventCRUDRepository eventRepository = new EventCRUDRepository();
        eventRepository.createEvent(event);
        eventRepository.saveEvent(event);

        event = eventRepository.getEventByID(event.getId());

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<!DOCTYPE html><html><body>"+event+"</body></html>");

    }
}

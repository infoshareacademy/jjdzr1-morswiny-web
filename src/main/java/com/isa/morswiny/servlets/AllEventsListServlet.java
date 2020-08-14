package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventCRUDRepository;
import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.repository.JsonEventDataLoad;
import com.isa.morswiny.users.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event-list")
public class AllEventsListServlet extends HttpServlet {

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        for (Event event : eventCRUDRepositoryInterface.getAllEventsList()) {
            if (event != null) {
                try {
                    writer.write("<!DOCTYPE html><html><body>" + event + "</body></html>");
                } catch (NullPointerException e) {
                    writer.write("<!DOCTYPE html><html><body>" + "Event not found" + "</body></html>");

                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("<!DOCTYPE html><html><body>" + "Nie ma takiego eventu." + "</body></html>");

            }
        }

    }
}



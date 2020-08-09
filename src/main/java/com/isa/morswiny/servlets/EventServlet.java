package com.isa.morswiny.servlets;

import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@ApplicationScoped
@WebServlet("/single-event")
public class EventServlet extends HttpServlet {

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        writer.println("Welcome to single event page");
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            writer.println(eventCRUDRepositoryInterface.getEventByID(id));
        } catch (NullPointerException e){
            writer.println("Event not found");
        }
    }
}

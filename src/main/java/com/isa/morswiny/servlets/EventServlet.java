package com.isa.morswiny.servlets;

import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        writer.println(eventCRUDRepositoryInterface.getEventByID(id));
    }
}

package com.isa.morswiny.servlets;

import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.eventsDao.EventSearchRepositoryInterface;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search-events")
public class SearchEventsServlet extends HttpServlet {

    @Inject
    EventSearchRepositoryInterface eventSearchRepositoryInterface;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        writer.println("Welcome to single event page");
        String userQuery = req.getParameter("random");
        try {
            writer.println(eventSearchRepositoryInterface.searchByString(userQuery));
        } catch (NullPointerException e){
            writer.println("Event not found");
        }
    }
}

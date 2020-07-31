package com.isa.morswiny.servlets;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventDataLoad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event-list")
public class AllEventsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
            EventDataLoad eventDataLoad = new EventDataLoad();
            Event[] list = eventDataLoad.getJsonEventData("/home/tom/Desktop/Morswiny-Web/jjdzr1-morswiny-web/src/main/resources/events.json");
            writer.println(list[0]);

    }
    //robi Mateo & Tomek

}

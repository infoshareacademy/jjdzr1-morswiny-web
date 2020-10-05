package com.isa.morswiny.servlets;

import com.isa.morswiny.eventsDao.EventEntityDao;
import com.isa.morswiny.model.EventEntity;
import com.isa.morswiny.services.EventsTestService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Inject
    EventsTestService eventsTestService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        eventsTestService.crud();


    }
}

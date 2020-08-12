package com.isa.morswiny.servlets;

import com.isa.morswiny.eventsDao.EventCRUDRepositoryInterface;
import com.isa.morswiny.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/single-event")
public class EventServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "singleEvent.ftml";

    @Inject
    EventCRUDRepositoryInterface eventCRUDRepositoryInterface;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;

        }
        Map<String, Object> map = new HashMap<>();
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            map.put("event", eventCRUDRepositoryInterface.getEventByID(id));
        } catch (NullPointerException e) {
            writer.println("Event not found");
        }

        Template template = templateProvider.createTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            STDOUT.error("Error while processing template: ", e);
        }
    }
}

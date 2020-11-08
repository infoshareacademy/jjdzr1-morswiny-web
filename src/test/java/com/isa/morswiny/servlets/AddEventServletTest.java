package com.isa.morswiny.servlets;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddEventServletTest {

    @Mock
    HttpServletResponse resp;

    @Mock
    HttpServletRequest req;

    @Mock
    ServletConfig sg;


    @Test

    public void parametersTest() throws IOException, ServletException {

//
//        when(req.getParameter("eventName")).thenReturn("Test name");
//        req.getParameter("eventName");
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
//        when(resp.getWriter()).thenReturn(writer);
//        writer.println("Test name");
//        resp.getWriter();
//        AddEventServlet servlet = new AddEventServlet();
//        servlet.init(sg);
//        servlet.doGet(req, resp);
//
//        verify(req).getParameter("eventName");

    }
}

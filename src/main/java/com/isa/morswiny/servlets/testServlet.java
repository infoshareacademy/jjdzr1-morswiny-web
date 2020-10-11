package com.isa.morswiny.servlets;

import org.apache.http.client.fluent.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/test")
public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = Request.Get("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=Ej81MRSQP0vEjHJLOyAILt9itAdXSYYi")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asString();

        PrintWriter writer = resp.getWriter();
        writer.print(response);

    }
}

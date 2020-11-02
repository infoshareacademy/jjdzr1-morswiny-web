package com.isa.morswiny.servlets;

import com.isa.morswiny.freemarker.TemplateProvider;
import com.isa.morswiny.services.FavouritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApplicationScoped //?
@WebServlet("/favourites-list")
public class FavouritesUserServlet extends HttpServlet {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String TEMPLATE_NAME = "favouritesUserList";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private FavouritesService favouritesService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        

    }


}

package com.isa.morswiny.usersDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserConnectionHiber {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configurationHiber = new Configuration();
        configurationHiber.configure("hibernate.cfg.xml");
        sessionFactory = configurationHiber.buildSessionFactory();
    }

    public static Session getSession () {
        return sessionFactory.openSession();
    }

    public static void close () {
        sessionFactory.close();
    }
}

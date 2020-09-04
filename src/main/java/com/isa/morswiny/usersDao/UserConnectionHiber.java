package com.isa.morswiny.usersDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserConnectionHiber {

    private static SessionFactory sessionFactory;

    static {
        Configuration configurationHiber = new Configuration();
        configurationHiber.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistryHiber = new StandardServiceRegistryBuilder()
                .applySettings(configurationHiber.getProperties()).build();
        sessionFactory = configurationHiber.buildSessionFactory(serviceRegistryHiber);
    }

    public static Session getSession () {
        return sessionFactory.openSession();
    }

    public void doWork() {}

    public static void close () {
        sessionFactory.close();
    }
}

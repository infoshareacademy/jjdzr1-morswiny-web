package com.isa.morswiny;

import com.isa.morswiny.eventsDao.EventRepository;

public class Main {
    public static void main(String[] args) {

        EventRepository er = new EventRepository();
        System.out.println(er.getEventByID(71944));

    }
}

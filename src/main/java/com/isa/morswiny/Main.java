package com.isa.morswiny;

import com.isa.morswiny.eventsDao.EventCRUDRepository;

public class Main {
    public static void main(String[] args) {

        EventCRUDRepository er = new EventCRUDRepository();
        System.out.println(er.getEventByID(71944));

    }
}

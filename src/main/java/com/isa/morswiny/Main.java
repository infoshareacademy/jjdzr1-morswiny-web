package com.isa.morswiny;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.eventsDao.EventRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // walczmy i budujmy!
        EventRepository er = new EventRepository();
        er.fillRepositoryWithJSONEvents();
        List<Event> list = er.getAllEventsList();
        for (Event event : list){
            System.out.println(event.getName() + " " + event.getStartDate() + " " + event.getEndDateLDT());
        }
    }
}

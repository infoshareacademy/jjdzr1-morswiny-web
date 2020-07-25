package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {


    private List<Event> allEventsList = new ArrayList<>();

    public void fillRepositoryWithJSONEvents(){
        setAllEventsList(new EventDataManagement().createListOfAllEvents());
    }

    public List<Event> getAllEventsList() {
        return allEventsList;
    }

    public void setAllEventsList(List<Event> allEventsList) {
        this.allEventsList = allEventsList;
    }
}

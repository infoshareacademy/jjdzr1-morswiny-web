package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class EventRepository implements EventCRUDRepositoryInterface , Serializable {

    private List<Event> allEventsList = new ArrayList<>();

    public void fillRepositoryWithJSONEvents(){
        setAllEventsList(new EventDataManagement().createListOfAllEvents());
    }

    public List<Event> getAllEventsList() {
        if (allEventsList.isEmpty()) {
            fillRepositoryWithJSONEvents();
        }
        return allEventsList;
    }

    public void setAllEventsList(List<Event> allEventsList) {
        this.allEventsList = allEventsList;
    }

    @Override
    public Event getEventByID(Integer id) {
        List<Event> list = getAllEventsList();
        for (Event event : list){
            if (id.equals(event.getId())){
                return event;
            }
        }
        return null;
    }
}

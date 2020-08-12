package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.repository.EventRepository;
import com.isa.morswiny.repository.JsonEventDataManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@SessionScoped
public class EventCRUDRepository implements EventCRUDRepositoryInterface , Serializable {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public List<Event> getAllEventsList() {
        return EventRepository.getEventRepository();
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

    @Override
    public boolean isEventExisting(Event event) {
        if (Objects.nonNull(event)){
        return getAllEventsList().contains(event);
        }
        return false;
    }

    @Override
    public Integer getNextID(){
        Event event = Collections.max(getAllEventsList(), Comparator.comparing(Event::getId));
        return event.getId() + 1;
    }

    @Override
    public boolean createEvent(Event event) {
        if (!isEventExisting(event)) {
            getAllEventsList().add(event);
            STDOUT.info("New event has been created\n");
            return true;
        } else {
            STDOUT.info("Event already existing or not defined");
        }
        return false;
    }
    @Override
    public boolean deleteEvent(Integer eventId) {
        Iterator i = getAllEventsList().iterator();
        while(i.hasNext()){
            Event event = (Event) i.next();
            if (eventId.equals(event.getId()))
                i.remove();
            return true;
        }

        return false;
    }
    @Override
    public boolean updateEvent(Event event){
        if (getAllEventsList().contains(event)){
            deleteEvent(event.getId());
            createEvent(event);
        }
        return false;
    }

    @Override
    public boolean saveEvent(Event event){
        if (Objects.nonNull(event)) {
            getAllEventsList().add(event);
        }
        return false;
    }
}
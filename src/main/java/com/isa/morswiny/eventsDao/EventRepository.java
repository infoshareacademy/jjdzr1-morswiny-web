package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

@SessionScoped
public class EventRepository implements EventCRUDRepositoryInterface , Serializable {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
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

    @Override
    public boolean isEventExisting(Event event) {
        return Objects.nonNull(event) && allEventsList.contains(event);
    }

    @Override
    public Integer getNextID(){
        Event event = Collections.max(allEventsList, Comparator.comparing(Event::getId));
        return event.getId() + 1;
    }

    @Override
    public boolean createEvent(Event event) {
        if (!isEventExisting(event)) {
            allEventsList.add(event);
            STDOUT.info("New event has been created successfully! \n");
            return true;
        } else {
            STDOUT.info("Event already existing or not defined!");
        }
        return false;
    }
    @Override
    public boolean deleteEvent(Integer eventId) {
        for (Event event : allEventsList) {
            if (eventId.equals(event.getId())) {
                allEventsList.remove(event);
                STDOUT.info("Event has been deleted");
                return true;
            }
        }
        STDOUT.info("\nFailed! Please try again");
        return false;
    }
    @Override
    public boolean updateEvent(Event event){
        if (allEventsList.contains(event)){
            deleteEvent(event.getId());
            createEvent(event);
        }
        return false;
    }

    @Override
    public boolean saveEvent(Event event){
        if (event != null) {
            allEventsList.add(event);
        }
        return false;
    }
}

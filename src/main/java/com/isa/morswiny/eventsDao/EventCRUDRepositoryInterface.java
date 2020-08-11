package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;

import javax.ejb.Local;


@Local
public interface EventCRUDRepositoryInterface {

    Event getEventByID(Integer id);
    boolean isEventExisting(Event event);
    Integer getNextID();
    boolean createEvent(Event event);
    boolean deleteEvent(Integer eventId);
    boolean updateEvent(Event event);
    boolean saveEvent(Event event);
}

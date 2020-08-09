package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;

import javax.inject.Inject;


public interface EventCRUDRepositoryInterface {

    Event getEventByID(Integer id);
}

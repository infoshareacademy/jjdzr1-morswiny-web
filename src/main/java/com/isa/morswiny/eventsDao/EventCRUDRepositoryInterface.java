package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;




public interface EventCRUDRepositoryInterface {

    Event getEventByID(Integer id);
}

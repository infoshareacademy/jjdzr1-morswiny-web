package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventEntity;
import com.isa.morswiny.model.OrganizerEntity;
import com.isa.morswiny.repository.JsonEventDataManagement;
import com.isa.morswiny.toBeDeleted.Event;
import com.isa.morswiny.toBeDeleted.Organizer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class dupa {

    @Inject
    EventEntityDao eventEntityDao;
    @Inject
    OrganizerEntityDao organizerEntityDao;


    public  void loadEventsToDB() {
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        List<Event> listOfEvents = jsonEventDataManagement.createListOfAllEvents();
        EventEntity eventEntity = new EventEntity();
        OrganizerEntity organizerEntity = new OrganizerEntity();
        OrganizerEntity oE = new OrganizerEntity();
        oE.setDesignation("ssasa");
        oE.setId("1");

        //for (Event e : listOfEvents) {
        Event e = listOfEvents.get(0);
        eventEntity = mapEventToEventEntity(e);
        eventEntity.setOrganizer(oE);
        eventEntityDao.save(eventEntity);

        organizerEntity = mapOrganizerToOrganizerEntity(e.getOrganizer());
        organizerEntity.getEvents().add(eventEntity);
        organizerEntityDao.save(organizerEntity);


        eventEntity = null;
        organizerEntity = null;
        //}


    }


    private EventEntity mapEventToEventEntity(Event event) {

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(event.getId());
        eventEntity.setEndDate(event.getEndDate());
        eventEntity.setName(event.getName());
        eventEntity.setDescLong(event.getDescLong());
        eventEntity.setCategoryId(event.getCategoryId());
        eventEntity.setStartDate(event.getStartDate());
        eventEntity.setActive(event.getActive());
        eventEntity.setStartDateLDT(event.getStartDateLDT());
        eventEntity.setEndDateLDT(event.getEndDateLDT());

        return eventEntity;

    }

    private OrganizerEntity mapOrganizerToOrganizerEntity(Organizer organizer) {
        OrganizerEntity organizerEntity = new OrganizerEntity();

        organizerEntity.setId(organizer.getId());
        if (organizer.getDesignation() == null) {
        } else {
            organizerEntity.setDesignation(organizer.getDesignation());
        }


        return organizerEntity;
    }
}

package com.isa.morswiny.services;

import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.eventsDao.EventSearchRepositoryInterface;
import com.isa.morswiny.model.Event;

import javax.inject.Inject;

public class EventService {

    @Inject
    EventSearchRepositoryInterface eventSearchRepositoryInterface;






    private EventDto provideEventDto (Event event){
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setStartDateLDT(event.getStartDateLDT());
        eventDto.setEndDateLDT(event.getEndDateLDT());
        eventDto.setPlace(event.getPlace());
        eventDto.setUrls(event.getUrls());
        eventDto.setAttachments(event.getAttachments());
        eventDto.setOrganizer(event.getOrganizer());

        return eventDto;
    }

    private Event provideEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setDescLong(eventDto.getDescLong());
        event.setCategoryId(eventDto.getCategoryId());
        event.setStartDateLDT(eventDto.getStartDateLDT());
        event.setEndDateLDT(eventDto.getEndDateLDT());
        event.setPlace(eventDto.getPlace());
        event.setUrls(eventDto.getUrls());
        event.setAttachments(eventDto.getAttachments());
        event.setOrganizer(eventDto.getOrganizer());

        return event;
    }





}


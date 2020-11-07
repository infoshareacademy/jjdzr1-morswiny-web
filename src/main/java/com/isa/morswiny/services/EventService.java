package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.Dao.EventSearchRepositoryInterface;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.Event;

import java.time.LocalDateTime;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static java.util.stream.Collectors.*;

@RequestScoped
public class EventService {

    @Inject
    private EventDao eventDao;


    private EventDto eventToDto (Event event){
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setId(event.getId());
        eventDto.setActive(event.getActive());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setStartDateLDT(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setEndDateLDT(event.getEndDate());
        eventDto.setPlace(event.getPlace());
        eventDto.setUrls(event.getUrls());
        eventDto.setAttachments(event.getAttachments());
        eventDto.setOrganizer(event.getOrganizer());

        return eventDto;
    }

    private Event dtoToEvent (EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setId(eventDto.getId());
        event.setActive(eventDto.getActive());
        event.setDescLong(eventDto.getDescLong());
        event.setCategoryId(eventDto.getCategoryId());
        event.setStartDate(eventDto.getStartDate());
        event.setStartDateLDT(LocalDateTime.parse(eventDto.getStartDateLDT()));
        event.setEndDate(eventDto.getEndDate());
        event.setEndDateLDT(LocalDateTime.parse(eventDto.getEndDateLDT()));
        event.setPlace(eventDto.getPlace());
        event.setUrls(eventDto.getUrls());
        event.setAttachments(eventDto.getAttachments());
        event.setOrganizer(eventDto.getOrganizer());

        return event;
    }


    public EventDto saveEvent (EventDto eventDto) {
        Event event = eventDao.save(dtoToEvent(eventDto));
        return eventToDto(event);
    }

    public List<EventDto> findByFreeText (String query) {
        return eventDao
                .findEventsByString(query)
                .stream()
                .map(this::eventToDto)
                .collect(toList());

    }

    public List<EventDto> findLatestEvents (int numOfEventsToFind){
        return eventDao
                .findLatestEvents(numOfEventsToFind)
                .stream()
                .map(this::eventToDto)
                .collect(toList());
    }


    public boolean checkIfExistsByOldIdFromJson(Integer id){

        return eventDao.find(id).isPresent();

    }



}


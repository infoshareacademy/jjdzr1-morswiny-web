package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventURLDao;
import com.isa.morswiny.Dao.OrganizerDao;
import com.isa.morswiny.dto.EventURLDto;
import com.isa.morswiny.dto.OrganizerDto;
import com.isa.morswiny.model.EventURL;
import com.isa.morswiny.model.Organizer;

import javax.inject.Inject;

public class EventURLService {

    @Inject
    EventURLDao eventURLDao;

    private EventURLDto eventURLDToDto (EventURL eventURL){
        EventURLDto eventURLDto = new EventURLDto();
        eventURLDto.setTickets(eventURL.getTickets());
        eventURLDto.setWww(eventURL.getWww());
        return eventURLDto;
    }

    private EventURL dtoToEventURL (EventURLDto eventURLDto) {
        EventURL eventURL = new EventURL();
        eventURL.setTickets(eventURLDto.getTickets());
        eventURL.setWww(eventURLDto.getWww());
        return eventURL;

    }

    public EventURLDto saveEventURL (EventURLDto eventURLDto) {
        EventURL eventURL = eventURLDao.save(dtoToEventURL(eventURLDto));
        return eventURLDToDto(eventURL);
    }

}

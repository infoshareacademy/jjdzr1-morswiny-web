package com.isa.morswiny.services;

import com.isa.morswiny.Dao.OrganizerDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.OrganizerDto;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.Organizer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@RequestScoped
public class OrganizerService {

    @Inject
    OrganizerDao organizerDao;

    private OrganizerDto organizerToDto (Organizer organizer){
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setDesignation(organizer.getDesignation());
        organizerDto.setId(organizer.getId());
        return organizerDto;
    }

    private Organizer dtoToOrganizer (OrganizerDto organizerDto) {
        Organizer organizer = new Organizer();
        organizer.setDesignation(organizerDto.getDesignation());
        organizer.setId(organizerDto.getId());
        return organizer;
    }

   public OrganizerDto saveOrganizer (OrganizerDto organizerDto) {
    Organizer organizer = organizerDao.save(dtoToOrganizer(organizerDto));
   return organizerToDto(organizer);
   }
}

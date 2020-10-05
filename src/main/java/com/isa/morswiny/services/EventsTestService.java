package com.isa.morswiny.services;

import com.isa.morswiny.eventsDao.EventEntityDao;
import com.isa.morswiny.model.*;
import com.isa.morswiny.toBeDeleted.Attachment;
import com.isa.morswiny.toBeDeleted.Organizer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashSet;

@Stateless
public class EventsTestService {

    @Inject
    EventEntityDao eventEntityDao;

    public void crud(){

        AttachmentEntity[] attachments1 = new AttachmentEntity[1];
        attachments1[0].setFileName("zalacznik");
        PlaceEntity placeEntity1 = new PlaceEntity();
        placeEntity1.setId("1");
        placeEntity1.setName("nazwa miejsca");
        placeEntity1.setSubname("podnazwa miejsca");
        EventURLEntity eventURLEntity1 = new EventURLEntity();
        eventURLEntity1.setTickets("bilety");
        eventURLEntity1.setWww("wwww.bilety.pl");
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setEndTicket("koniec biletow");
        ticketEntity.setStartTicket("poczatek biletow");
        ticketEntity.setType("bilety on-line");
        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setDesignation("organizator eventu");
        organizerEntity.setId("1");



        EventEntity eventEntity1 = new EventEntity();
        eventEntity1.setAttachments(attachments1);
        HashSet<EventEntity> map = new HashSet<>();
        eventEntity1.setPlaces(new HashSet<PlaceEntity>());
        eventEntity1.getPlaces().add(placeEntity1);
        eventEntity1.setOrganizer(organizerEntity);
        eventEntity1.setName("wydarzenie");

        eventEntityDao.save(eventEntity1);







    }
}

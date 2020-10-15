package com.isa.morswiny.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "event")


public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;
    private Integer id;
    private String endDate;
    private String name;
    private String descLong;
    private String categoryId;
    private String startDate;
    private Integer  active;
    private LocalDateTime startDateLDT;
    private LocalDateTime endDateLDT;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="place_id", referencedColumnName = "placeId")
    private PlaceEntity place;

    @OneToOne
    @JoinColumn (name="url_id", referencedColumnName = "eventUrlId")
    private EventURLEntity urls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="event_Id")
    @OrderColumn
    private AttachmentEntity[] attachments;

    @ManyToOne
    @JoinColumn(name="organizer_Id", referencedColumnName = "organizerId")
    private OrganizerEntity organizer;

    @OneToOne 
    @JoinColumn(name="ticket_id", referencedColumnName = "ticketId")
    private TicketEntity tickets;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public LocalDateTime getStartDateLDT() {
        return startDateLDT;
    }

    public void setStartDateLDT(LocalDateTime startDateLDT) {
        this.startDateLDT = startDateLDT;
    }

    public LocalDateTime getEndDateLDT() {
        return endDateLDT;
    }

    public void setEndDateLDT(LocalDateTime endDateLDT) {
        this.endDateLDT = endDateLDT;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public EventURLEntity getUrls() {
        return urls;
    }

    public void setUrls(EventURLEntity urls) {
        this.urls = urls;
    }

    public AttachmentEntity[] getAttachments() {
        return attachments;
    }

    public void setAttachments(AttachmentEntity[] attachments) {
        this.attachments = attachments;
    }

    public OrganizerEntity getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerEntity organizer) {
        this.organizer = organizer;
    }

    public TicketEntity getTickets() {
        return tickets;
    }

    public void setTickets(TicketEntity tickets) {
        this.tickets = tickets;
    }


}

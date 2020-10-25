package com.isa.morswiny.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;
    private Integer id;
    private String endDate;
    private String name;

    @Column(length = 16777215)
    private String descLong;
    private String categoryId;
    private String startDate;
    private Integer  active;
    private LocalDateTime startDateLDT;
    private LocalDateTime endDateLDT;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="place_id", referencedColumnName = "placeId")
    private Place place;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="url_id", referencedColumnName = "eventUrlId")
    private EventURL urls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_Id")
    @OrderColumn
    private Attachment[] attachments;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="organizer_Id", referencedColumnName = "organizerId")
    private Organizer organizer;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="ticket_id", referencedColumnName = "ticketId")
    private Ticket tickets;


    public String returnEventParams() {
        return
                ""  + '\n' //+place.getName() + place.getSubname() + '\n'
                        + endDate + '\n'
                        + name + '\n'
                        + urls.getWww() + urls.getTickets() + '\n'
                        + startDate + '\n'
                        + descLong + '\n'
                        + organizer.getDesignation() + '\n';
    }


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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public EventURL getUrls() {
        return urls;
    }

    public void setUrls(EventURL urls) {
        this.urls = urls;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachment[] attachments) {
        this.attachments = attachments;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }
}
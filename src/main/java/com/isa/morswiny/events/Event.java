package com.isa.morswiny.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Event {
    private Integer id;
    private Place place;
    private String endDate;
    private String name;
    private EventURL urls;
    private Attachment[] attachments;
    private String descLong;
    private String categoryId;
    private String startDate;
    private Organizer organizer;
    private Integer  active;
    private Ticket tickets;
    private LocalDateTime startDateLDT;
    private LocalDateTime endDateLDT;

    public Event(){
    }

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(place, event.place) &&
                Objects.equals(endDate, event.endDate) &&
                Objects.equals(name, event.name) &&
                Objects.equals(urls, event.urls) &&
                Arrays.equals(attachments, event.attachments) &&
                Objects.equals(descLong, event.descLong) &&
                Objects.equals(categoryId, event.categoryId) &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(organizer, event.organizer) &&
                Objects.equals(active, event.active) &&
                Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, place, endDate, name, urls, descLong, categoryId, startDate, organizer, active, tickets);
        result = 31 * result + Arrays.hashCode(attachments);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", place=" + place +
                ", endDate=" + endDate  +
                ", name=" + name  +
                ", urls=" + urls +
                ", categoryId=" + categoryId  +
                ", startDate=" + startDate  +
                ", organizer=" + organizer +
                ", active=" + active +
                '}';
    }

    public String returnEventParams() {
        return
                ""  + '\n' + place.getName() + place.getSubname() + '\n'
                        + endDate + '\n'
                        + name + '\n'
                        + urls.getWww() + urls.getTickets() + '\n'
                        + startDate + '\n'
                        + descLong + '\n'
                        + organizer.getDesignation() + '\n';
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
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

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }


}

package com.isa.morswiny.dto;

import com.isa.morswiny.model.*;

import java.time.LocalDateTime;

public class EventDto {
    private Integer eventId;
    private Integer id;
    private String name;
    private String descLong;
    private String categoryId;
    private LocalDateTime startDateLDT;
    private LocalDateTime endDateLDT;
    private Place place;
    private EventURL urls;
    private Attachment[] attachments;
    private Organizer organizer;



    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.isa.morswiny.toBeDeleted;

import com.isa.morswiny.model.EventEntity;

import javax.persistence.*;
import java.util.Set;

public class Organizer {
    public Integer getOrganizerID() {
        return organizerID;
    }
    private Integer organizerID;
    private String id;
    private String designation;
    private Set<EventEntity> events;

    public Organizer(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Organizer() {

    }

    @Override
    public String toString() {
        return "designation : " + designation ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

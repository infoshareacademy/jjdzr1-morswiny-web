package com.isa.morswiny.events;

import javax.persistence.*;

@Entity
@Table (name ="organizer")
public class Organizer {
    public Integer getOrganizerID() {
        return organizerID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer organizerID;
    private String id;
    private String designation;

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

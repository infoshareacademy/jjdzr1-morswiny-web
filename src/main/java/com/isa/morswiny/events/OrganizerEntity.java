package com.isa.morswiny.events;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name ="organizer")
public class OrganizerEntity {
    public Integer getOrganizerID() {
        return organizerID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer organizerID;
    private String id;
    private String designation;
    @OneToMany (mappedBy = "organizer")
    private Set<EventEntity> events;

    public OrganizerEntity(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public OrganizerEntity() {

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

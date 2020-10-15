package com.isa.morswiny.toBeDeleted;



import javax.persistence.*;
import java.util.Set;

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
    @OneToMany (mappedBy = "organizer", cascade = CascadeType.ALL)
    private Set<Event> events;

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

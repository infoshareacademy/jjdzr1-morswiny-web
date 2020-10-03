package com.isa.morswiny.model;

import javax.persistence.*;

@Entity
@Table(name="url")
public class EventURLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventUrlId;
    private String www;
    private String tickets;

    @OneToOne
    @JoinColumn(name="event_id", referencedColumnName = "eventId")
    private EventEntity event;

    public EventURLEntity(String www, String tickets) {
        this.www = www;
        this.tickets = tickets;
    }

    public EventURLEntity() {

    }

    @Override
    public String toString() {
        return "EventURL " +
                "www = " + www ;

    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }
}

package com.isa.morswiny.events;

import javax.persistence.*;

@Entity
@Table(name="url")
public class EventURL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventUrlId;
    private String www;
    private String tickets;

    public EventURL(String www, String tickets) {
        this.www = www;
        this.tickets = tickets;
    }

    public EventURL() {

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

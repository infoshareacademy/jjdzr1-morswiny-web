package com.isa.morswiny.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "event")

public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;
    private Integer id;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_and_place_join_table",
            joinColumns = @JoinColumn(name = "eventID"),
            inverseJoinColumns = @JoinColumn(name = "placeId"))
    private Set<PlaceEntity> places = new HashSet<>();

    private String endDate;
    private String name;

    @OneToOne
    @JoinColumn(name = "url_id", referencedColumnName = "eventUrlId")
    private EventURLEntity urls;


    private String descLong;
    private String categoryId;
    private String startDate;


    private Integer  active;




    private LocalDateTime startDateLDT;
    private LocalDateTime endDateLDT;



}

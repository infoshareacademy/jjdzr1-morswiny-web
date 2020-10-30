package com.isa.morswiny.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "favourites")
public class Favourites {

    @Id
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


    @ManyToMany
    private Set<User> user;



}

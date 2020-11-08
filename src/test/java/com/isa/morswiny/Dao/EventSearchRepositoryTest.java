package com.isa.morswiny.Dao;


import com.isa.morswiny.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


public class EventSearchRepositoryTest {

    private static List<Event> testEvents;
    private static EventSearchRepository eventSearchRepository;
    private static Event event1;
    private static Event event2;

    @BeforeAll
    static void setUpData() {
        eventSearchRepository = new EventSearchRepository();

    }

    public void testSearchByString() {

    }

    public void testSearchByOrganizer() {

    }

    public void testSearchByPlace() {
    }

    public void testSearchActive() {

    }

    public void testSearchByName() {
    }
}
package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class EventDbLoadServiceTest {


    @Test
    void saveEventsFromJsonTest(){

        Event event1 = new Event();
        event1.setId(1);
        event1.setName("First Event");

        Event event2 = new Event();
        event2.setId(2);
        event2.setName("Second Event");

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        EventDbLoadService eventDbLoadService = mock(EventDbLoadService.class);
        doNothing().when(eventDbLoadService).saveEventsFromJson(isA(List.class));
        eventDbLoadService.saveEventsFromJson(events);

        verify(eventDbLoadService, times(1)).saveEventsFromJson(events);

    }
}

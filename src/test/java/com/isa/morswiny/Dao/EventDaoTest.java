package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EventDaoTest {


    @Mock
    EventDao mockEventDao;


    @Test
    void saveEventToDatabaseTest(){

        Event event = new Event();

        EventDao eventDao = mock(EventDao.class);
        doNothing().when(eventDao).save(isA(Event.class));
        eventDao.save(event);

        verify(eventDao, times(1)).save(event);

    }

    @Test
    void updateEventTest(){

        Event event = new Event();
        event.setEventId(1);
        event.setName("New Event");
        mockEventDao.save(event);

        event.setName("Newest Event");
        event.setEndDate("12.12.2020");

        mockEventDao.update(event);


        Assertions.assertEquals(event.getName(), "Newest Event");
        Assertions.assertEquals(event.getEndDate(), "12.12.2020");


    }

    @Test
    void deleteEventFromDatabaseTest(){

        Event event = new Event();
        event.setEventId(1);
        event.setName("New Event");
        mockEventDao.save(event);
        mockEventDao.delete(event);

        Assertions.assertEquals(mockEventDao.find(event.getId()), Optional.empty());


    }

    @Test
    void findTest(){


        //given
        Event event = new Event();
        event.setEventId(1);
        event.setName("New Event");

        //when
        when(mockEventDao.find(any(Integer.class))).thenReturn(Optional.empty());
        when(mockEventDao.find(event.getEventId())).thenReturn(Optional.of(event));
        Optional<Event> resultRandom = mockEventDao.find(2);
        Optional<Event> resultEvent = mockEventDao.find(event.getEventId());

        //then
        Assertions.assertEquals(resultRandom,Optional.empty());
        Assertions.assertEquals(resultEvent,Optional.of(event));
    }

    @Test
    void findAllEventsTest(){

        Event event1 = new Event();
        event1.setEventId(1);
        event1.setName("First Event");

        Event event2 = new Event();
        event2.setEventId(2);
        event2.setName("Second Event");

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        when(mockEventDao.findAllEvents()).thenReturn(events);

        Assertions.assertEquals(events, mockEventDao.findAllEvents());
    }

    @Test
    void findLatestEventsTest(){

//        Event event1 = new Event();
//        event1.setEventId(1);
//        event1.setStartDateLDT(LocalDateTime.of(2019, 12,12, 20, 20));
//
//        Event event2 = new Event();
//        event2.setEventId(2);
//        event2.setStartDateLDT(LocalDateTime.of(2020, 12,12, 20, 20));
//
//        List<Event> events = new ArrayList<>();
//        events.add(event1);
//        events.add(event2);
//
//        when(mockEventDao.findLatestEvents(1)).thenReturn(events);
//
//        Assertions.assertEquals(1, events.size());

    }
}

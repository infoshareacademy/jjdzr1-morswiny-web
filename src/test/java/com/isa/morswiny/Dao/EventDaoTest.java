package com.isa.morswiny.Dao;

import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;
import com.isa.morswiny.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EventDaoTest {


    @Mock
    EntityManager mockEntityManager;

    @InjectMocks
    EventDao eventDao;



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
        Event updated = new Event();
        when(eventDao.update(any(Event.class))).thenReturn(updated);

        updated = eventDao.update(event);
        updated.setName("Updated");
        Assertions.assertNotSame(event.getName(), updated.getName());


    }

    @Test
    void deleteEventFromDatabaseTest(){

        Event event = new Event();
        event.setEventId(1);
        event.setName("New Event");
        eventDao.save(event);
        eventDao.delete(event);

        Assertions.assertEquals(eventDao.find(event.getId()), Optional.empty());


    }

    @Test
    void findTest(){

        EventDao eventDao = mock(EventDao.class);
        //given
        Event event = new Event();
        event.setEventId(1);
        event.setName("New Event");

        //when
        when(eventDao.find(any(Integer.class))).thenReturn(Optional.empty());
        when(eventDao.find(event.getEventId())).thenReturn(Optional.of(event));
        Optional<Event> resultRandom = eventDao.find(2);
        Optional<Event> resultEvent = eventDao.find(event.getEventId());

        //then
        Assertions.assertEquals(resultRandom,Optional.empty());
        Assertions.assertEquals(resultEvent,Optional.of(event));
    }

    @Test
    void findAllEventsTest(){
        EventDao eventDao = mock(EventDao.class);
        Event event1 = new Event();
        event1.setEventId(1);

        Event event2 = new Event();
        event2.setEventId(2);

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        when(eventDao.findAllEvents()).thenReturn(events);

        List<Event> created = eventDao.findAllEvents();
        Assertions.assertEquals(events.size(), created.size());
    }

    @Test
    void findLatestEventsTest(){
        EventDao eventDao = mock(EventDao.class);
        Event event1 = new Event();
        event1.setEventId(1);
        event1.setStartDateLDT(LocalDateTime.of(2019, 12,12, 20, 20));

        Event event2 = new Event();
        event2.setEventId(2);
        event2.setStartDateLDT(LocalDateTime.of(2020, 12,12, 20, 20));

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        when(eventDao.findLatestEvents(2)).thenReturn(events);

        List<Event> created  = eventDao.findLatestEvents(2);

        Assertions.assertSame(2, created.size());

    }
}

package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    EventService eventService;

    @InjectMocks
    EventDao eventDao;

    @Test
    void saveEventTest(){

        EventDto eventDto = new EventDto();
        eventDto.setEventId(1);
        eventDto.setName("New name");
        eventDto.setDescLong("Description");
        eventDto.setCategoryId("Category");
        eventDto.setStartDate("12.12.2020");
        eventDto.setEndDate("12.12.2020");
        Place place = new Place();
        place.setName("New place");
        eventDto.setPlace(place);
        EventURL url = new EventURL();
        url.setWww("www");
        eventDto.setUrls(url);
        Attachment[] attachments = new Attachment[0];
        eventDto.setAttachments(attachments);
        Organizer organizer = new Organizer();
        organizer.setDesignation("Organizer");
        eventDto.setOrganizer(organizer);

        eventService.saveEvent(eventDto);

        verify(eventService, times(1)).saveEvent(eventDto);

    }

}

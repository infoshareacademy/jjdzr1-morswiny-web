package com.isa.morswiny.services;

import com.isa.morswiny.dto.EventDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FavouritesServiceTest {

    @Mock
    private FavouritesService favouritesService;

    @Test
    void saveFavouriteForUserTest(){

        EventDto eventDto = new EventDto();
        eventDto.setEventId(1);

        when(favouritesService.saveFavouritesForUser(null)).thenThrow(NullPointerException.class);
        when(favouritesService.saveFavouritesForUser(eventDto.getEventId())).thenReturn(eventDto);

        Assertions.assertThrows(NullPointerException.class, ()-> favouritesService.saveFavouritesForUser(null));
        Assertions.assertEquals(favouritesService.saveFavouritesForUser(eventDto.getEventId()), eventDto);

    }

    @Test
    void deleteFavouriteTest(){

        EventDto eventDto = new EventDto();
        eventDto.setEventId(1);

        when(favouritesService.deleteFavouritesForUser(null)).thenThrow(NullPointerException.class);
        when(favouritesService.deleteFavouritesForUser(eventDto.getEventId())).thenReturn(true);
        boolean result = favouritesService.deleteFavouritesForUser(1);

        Assertions.assertThrows(NullPointerException.class, ()-> favouritesService.deleteFavouritesForUser(null));
        Assertions.assertTrue(result);




    }
}

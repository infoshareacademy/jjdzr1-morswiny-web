package com.isa.morswiny.services;

import com.isa.morswiny.dto.EventDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void saveFavouriteForUserTest(){

//        EventDto eventDto = new EventDto();
//        eventDto.setEventId(1);
//
//        when(favouritesService.addToFavourites(null, null)).thenThrow(NullPointerException.class);
//        when(favouritesService.addToFavourites(eventDto.getEventId(), eventDto)).thenReturn(eventDto);
//
//        Assertions.assertThrows(NullPointerException.class, ()-> favouritesService.addToFavourites(null, null));
//        Assertions.assertEquals(favouritesService.addToFavourites(eventDto.getEventId()), eventDto);

    }

    @Test
    @Disabled
    void deleteFavouriteTest(){

//        EventDto eventDto = new EventDto();
//        eventDto.setEventId(1);
//
//        when(favouritesService.removeFromFavourite(1)).thenThrow(NullPointerException.class);
//        when(favouritesService.removeFromFavourite(eventDto.getEventId())).thenReturn(true);
//        boolean result = favouritesService.removeFromFavourite(1);
//
//        Assertions.assertThrows(NullPointerException.class, ()-> favouritesService.removeFromFavourite(null));
//        Assertions.assertTrue(result);


    }
}

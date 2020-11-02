package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.Dao.FavouritesDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestScoped
public class FavouritesService {

    @Inject
    private FavouritesDao favouritesDao;
//
//    @Inject
//    private EventDao eventDao;
//

    @Transactional
    public EventDto saveFavouritesForUser(String id){
        Event event = favouritesDao.saveFavouritesForUser(id);
        return provideEventDto(event);

    }

    @Transactional
    public boolean deleteFavouritesForUser(String id){
        Integer intId = Integer.parseInt(id);
        Optional<Event> event = favouritesDao.find(intId);
        if(event.isEmpty()){
            return false;
        }else{
            favouritesDao.deleteFavouritesForUser(id);
            return true;
        }
    }

    @Transactional
    public List<EventDto> getAllFavouritesForUser(String id){
        List<Event> favourites = favouritesDao.getFavouritesForUserId(id);
        return favourites.stream()
                .map(FavouritesService::provideEventDto)
                .collect(Collectors.toList());
    }

    private static EventDto provideEventDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setStartDateLDT(event.getStartDateLDT());
        eventDto.setEndDateLDT(event.getEndDateLDT());
        eventDto.setPlace(event.getPlace());
        eventDto.setUrls(event.getUrls());
        eventDto.setAttachments(event.getAttachments());
        eventDto.setOrganizer(event.getOrganizer());

        return eventDto;
    }

    private static Event provideEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setDescLong(eventDto.getDescLong());
        event.setCategoryId(eventDto.getCategoryId());
        event.setStartDateLDT(eventDto.getStartDateLDT());
        event.setEndDateLDT(eventDto.getEndDateLDT());
        event.setPlace(eventDto.getPlace());
        event.setUrls(eventDto.getUrls());
        event.setAttachments(eventDto.getAttachments());
        event.setOrganizer(eventDto.getOrganizer());

        return event;
    }
}

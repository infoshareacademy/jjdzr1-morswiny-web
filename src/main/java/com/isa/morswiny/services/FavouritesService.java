package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.Dao.FavouritesDao;
import com.isa.morswiny.dto.EventDto;
import com.isa.morswiny.dto.UserDto;
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

    public EventDto saveFavouritesForUser(Integer eventId){
        Event event = favouritesDao.saveFavouritesForUser(eventId);
        return provideEventDto(event);

    }

    public boolean deleteFavouritesForUser(Integer eventId){
        Optional<Event> event = favouritesDao.find(eventId);
        if(event.isEmpty()){
            return false;
        }else{
            favouritesDao.deleteFavouritesForUser(eventId);
            return true;
        }
    }

    public List<EventDto> getAllFavouritesForUser(Integer userId){
        List<Event> favourites = favouritesDao.getFavouritesForUserId(userId);
        return favourites.stream()
                .map(FavouritesService::provideEventDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserByEmail(String email){
        if(favouritesDao.getByEmail(email) == null){
            return null;
        }else{
            return UserService.userToDto(favouritesDao.getByEmail(email));
        }
    }

    private static EventDto provideEventDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
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
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setPlace(eventDto.getPlace());
        event.setUrls(eventDto.getUrls());
        event.setAttachments(eventDto.getAttachments());
        event.setOrganizer(eventDto.getOrganizer());

        return event;
    }
}

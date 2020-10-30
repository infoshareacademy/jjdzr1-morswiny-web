package com.isa.morswiny.repository;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RequestScoped
public class EventRepository {
    @Inject
    private EventDao eventDao;


    private static List<Event> eventRepository = new ArrayList<>();

    //TODO - dodawanie nowych eventow
    public static List<Event> getEventRepository() throws IOException {
        if(eventRepository.size() == 0){
            fillEventRepositoryWithJsonEvents();
        }
        return eventRepository;
    }

    public static void fillEventRepositoryWithJsonEvents() throws IOException {
        eventRepository.addAll(new JsonEventDataManagement().createListOfAllEvents());
    }

    public void loadDataToDB() throws IOException {
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        List<Event> listOfEvents = jsonEventDataManagement.createListOfAllEvents();
        listOfEvents.forEach(event -> eventDao.save(event));
    }



}

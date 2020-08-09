package com.isa.morswiny.repository;

import com.isa.morswiny.events.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    private static List<Event> eventRepository = new ArrayList<>();

    //TODO - dodawanie nowych eventow
    public static List<Event> getEventRepository() {
        if(eventRepository.size() == 0){
            fillEventRepositoryWithJsonEvents();
        }
        return eventRepository;
    }

    public static void fillEventRepositoryWithJsonEvents(){
        eventRepository.addAll(new JsonEventDataManagement().createListOfAllEvents());
    }



}

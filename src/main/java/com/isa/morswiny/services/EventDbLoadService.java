package com.isa.morswiny.services;

import com.isa.morswiny.eventsDao.EventDao;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.*;

@RequestScoped
public class EventDbLoadService {
    @Inject
    private EventDao eventDao;


    @Transactional
    public void saveEventsFromJson(List<Event> events) {
        events.stream()
                .filter(e -> eventDao.find(e.getId()).isEmpty())
                .forEach(e -> eventDao.save(e));
    }

}

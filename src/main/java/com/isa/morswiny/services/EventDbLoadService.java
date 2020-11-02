package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;

@RequestScoped
public class EventDbLoadService {

    @Inject
    private EventDao eventDao;

    @Transactional
    public boolean saveEventsFromDto(Event[] events) {
        Arrays.stream(events)
                .forEach(e -> eventDao.save(e));
        return true;
    }

}

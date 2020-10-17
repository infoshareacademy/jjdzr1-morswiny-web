package com.isa.morswiny.eventsDao;

import com.isa.morswiny.repository.JsonEventDataManagement;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DbDataLoad implements Serializable {

    @Inject
    private EventDao eventDao;

    public void loadDataToDB() {
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        List<Event> listOfEvents = jsonEventDataManagement.createListOfAllEvents();
        listOfEvents.forEach(event -> eventDao.save(event));

//
//        for (Event e : listOfEvents) {
//            eventDao.save(e);
//        }

    }

}

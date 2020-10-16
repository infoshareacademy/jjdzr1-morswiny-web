package com.isa.morswiny.eventsDao;

import com.isa.morswiny.repository.JsonEventDataManagement;
import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DbDataLoad {

    @Inject
    private EventDao eventDao;

    public void loadDataToDB() {
        List<Event> listOfEvents;
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        listOfEvents = jsonEventDataManagement.createListOfAllEvents();


        for (Event e : listOfEvents) {
            eventDao.save(e);
        }

    }

}

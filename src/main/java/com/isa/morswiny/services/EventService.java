package com.isa.morswiny.services;

import com.isa.morswiny.eventsDao.DbDataLoad;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EventService {

    @Inject
    private DbDataLoad dbDataLoad;

    public void load() {
        dbDataLoad.loadDataToDB();
    }
}

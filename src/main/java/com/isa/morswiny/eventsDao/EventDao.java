package com.isa.morswiny.eventsDao;

import com.isa.morswiny.repository.JsonEventDataManagement;
import com.isa.morswiny.toBeDeleted.Event;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EventDao implements Dao<Event>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Event event) {
        entityManager.persist(event);
    }

    @Override
    public Event update(Event event) {
        return entityManager.merge(event);

    }

    @Override
    public void delete(Event event) {
        entityManager.remove(event);
    }

    @Override
    public Optional<Event> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Event.class, id));
    }

    public void loadDataToDB() {
        List<Event> listOfEvents = new ArrayList<>();
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        listOfEvents = jsonEventDataManagement.createListOfAllEvents();

        Event event = listOfEvents.get(0);
        save(event);

        Event event1 = new Event();
        save(event1);

//        for (Event e : listOfEvents) {
//            save(e);
//        }

    }


}

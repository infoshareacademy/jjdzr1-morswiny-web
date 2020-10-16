package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@RequestScoped
public class EventDao implements Dao<Event> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
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


}

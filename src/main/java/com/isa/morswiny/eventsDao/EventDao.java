package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.Event;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.*;

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

    public List<Event> findEventsByString (String query) {

        if (query.equals(null)){
            return findAllEvents();
        }
        String a ="SELECT e FROM Event e WHERE (e.descLong like :query or e.name like :query or e.place.name like :query or e.organizer.designation like :query)";
        TypedQuery<Event> search = entityManager.createQuery(a,Event.class);
        search.setParameter("query", "%" + query + "%");
        return search.getResultList();
    }

    public List<Event> findAllEvents() {

        return entityManager.createQuery("select e from Event e",Event.class).getResultList();

    }

}

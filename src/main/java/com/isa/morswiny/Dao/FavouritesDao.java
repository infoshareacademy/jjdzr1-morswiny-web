package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;

    public Event saveFavouritesForUser(String eventId) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM Event u WHERE u.eventId = :eventId", Event.class);
        query.setParameter("eventId",eventId);
        Event event = query.getSingleResult();
        entityManager.persist(event);
        return event;
    }

    public void deleteFavouritesForUser(String eventId) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM User.favourites u WHERE u.eventId = :eventId", Event.class);
        query.setParameter("eventId",eventId);
        Event event = query.getSingleResult();
        if(event != null){
//            entityManager.remove(event);
            entityManager.remove(entityManager.contains(event) ? event : entityManager.merge(event));
        }
    }

    public List<Event> getFavouritesForUserId(String id) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM User.favourites u WHERE u.id = :id", Event.class);
        query.setParameter("id", id);
        List<Event> favourites = query.getResultList();
        if (favourites.isEmpty()) {
            return null;
        } else {
            return favourites;
        }
    }

    public Optional<Event> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Event.class, id));
    }
}

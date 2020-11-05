package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;

    public Event saveFavouritesForUser(Integer eventId) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM Event u WHERE u.eventId = :eventId", Event.class);
        query.setParameter("eventId",eventId);
        Event event = query.getSingleResult();
        entityManager.merge(event); //czy persist
        return event;
    }

    public void deleteFavouritesForUser(Integer eventId) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM User.favourites u WHERE u.eventId = :eventId", Event.class);
        query.setParameter("eventId",eventId);
        Event event = query.getSingleResult();
        if(event != null){
            entityManager.merge(entityManager.contains(event) ? event : entityManager.merge(event));
        }
    }

    public List<Event> getFavouritesForUserId(Integer id) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM User.favourites u WHERE u.id = :id", Event.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public Optional<Event> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Event.class, id));
    }

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email).getResultList();
        return query.getSingleResult();
    }

}

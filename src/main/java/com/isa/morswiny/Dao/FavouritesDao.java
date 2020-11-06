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
import java.util.Set;

@RequestScoped
public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;

    public Event saveFavouritesForUser(Integer eventId, Integer userId) {
        TypedQuery<Event> eventQuery = entityManager.createQuery(
                "SELECT u FROM Event u WHERE u.eventId = :eventId", Event.class);
        TypedQuery<User> userQuery = entityManager.createQuery(
                "SELECT u FROM User u WHERE userId = :userId", User.class);

        userQuery.setParameter("userId",userId);
        eventQuery.setParameter("eventId",eventId);

        Event event = eventQuery.getSingleResult();
        User user = userQuery.getSingleResult();
        Set<Event> favourites = user.getFavourites();

        if(!favourites.contains(event)){
            entityManager.persist(event);
            return event;
        }else{
            return null;
        }

    }

    public Event addEventToFavourites(Event event){
        entityManager.merge(event);
        return event;
    }

    public void removeEventFromFavourites(Event event) {
        entityManager.remove(entityManager.contains(event) ? event : entityManager.merge(event));
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

    public Set<Event> getFavouritesForUserId(Integer id) {
        TypedQuery<User> userQuery = entityManager.createQuery(
                "SELECT u FROM User u WHERE userId = :id", User.class);
        userQuery.setParameter("id", id);
        User user = userQuery.getSingleResult();
        Set<Event> events = user.getFavourites();
        return events;
    }

    public Optional<Event> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Event.class, id));
    }

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

}

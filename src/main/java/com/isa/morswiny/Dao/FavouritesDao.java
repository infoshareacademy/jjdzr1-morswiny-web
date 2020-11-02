package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(String id) {
        entityManager.persist(id);
    }

    public void delete(Event event) {
        entityManager.remove(event);

    }

    public List<Event> getFavouritesForUserId(String id) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM favourites u WHERE u.userid = :id", Event.class);
        query.setParameter("id", id);
        List<Event> favourites = query.getResultList();
        if (favourites.isEmpty()) {
            return null;
        } else {
            return favourites;
        }
    }
}

package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class FavouritesDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Event event) {
        entityManager.persist(event);

    }

    public void delete(Event event) {
        entityManager.remove(event);

    }

    public List<Event> getFavouritesForUserId(String id) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM favourites u WHERE u.userid = :id", Event.class);
        query.setParameter("id", id);
        List<Event> favourites = query.getResultList();
        if (favourites.isEmpty()){
            return null;
        } else {
            return favourites;
        }
    }
}

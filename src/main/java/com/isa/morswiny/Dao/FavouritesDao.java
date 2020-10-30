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


    @Override
    public void save(Event event) {

    }

    @Override
    public void delete(Event event) {

    }

    public List<Event> getFavouritesForUserId(String id) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT u FROM Event u WHERE u.userid = :id", Event.class);
        List<Event> favourites = query.setParameter("id", id).getResultList();
        if (favourites.isEmpty()){
            return null;
        } else {
            return favourites;
        }
    }
}

package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventURLEntity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@SessionScoped
public class EventURLEntityDao implements Dao<EventURLEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean save(EventURLEntity eventURLEntity) {
        try {
            entityManager.persist(eventURLEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(EventURLEntity eventURLEntity) {
        return false;
    }

    @Override
    public boolean delete(EventURLEntity eventURLEntity) {
        return false;
    }

    @Override
    public EventURLEntity find(Integer id) {
        return null;
    }
}

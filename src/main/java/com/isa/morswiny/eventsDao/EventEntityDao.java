package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class EventEntityDao implements Dao<EventEntity>, Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    public boolean save (EventEntity eventEntity){
        try {entityManager.persist(eventEntity);
        return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(EventEntity eventEntity) {
        return false;
    }

    @Override
    public boolean delete(EventEntity eventEntity) {
        return false;
    }

    @Override
    public EventEntity find(Integer id) {
        return null;
    }
}

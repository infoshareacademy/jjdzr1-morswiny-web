package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventURLEntity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@SessionScoped
public class EventURLEntityDao implements Dao<EventURLEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(EventURLEntity eventURLEntity) {

        entityManager.persist(eventURLEntity);
    }

    @Override
    public EventURLEntity update(EventURLEntity eventURLEntity) {

        return entityManager.merge(eventURLEntity);
    }

    @Override
    public void delete(EventURLEntity eventURLEntity) {
        entityManager.remove(eventURLEntity);
    }

    @Override
    public Optional<EventURLEntity> find(Integer id) {
        return Optional.ofNullable(entityManager.find(EventURLEntity.class, id));
    }
}

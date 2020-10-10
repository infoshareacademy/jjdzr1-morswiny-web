package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@ApplicationScoped
public class EventEntityDao implements Dao<EventEntity>, Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    public void save(EventEntity eventEntity) {
        entityManager.persist(eventEntity);
    }

    @Override
    public EventEntity update(EventEntity eventEntity) {
        return entityManager.merge(eventEntity);

    }

    @Override
    public void delete(EventEntity eventEntity) {
        entityManager.remove(eventEntity);
    }

    @Override
    public Optional<EventEntity> find(Integer id) {
        return Optional.ofNullable(entityManager.find(EventEntity.class, id));
    }
}

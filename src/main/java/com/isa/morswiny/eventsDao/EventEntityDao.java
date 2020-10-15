package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventEntity;
import com.isa.morswiny.model.OrganizerEntity;
import com.isa.morswiny.repository.JsonEventDataManagement;
import com.isa.morswiny.toBeDeleted.Event;
import com.isa.morswiny.toBeDeleted.Organizer;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class EventEntityDao implements Dao<EventEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

//    @Inject
//    OrganizerEntityDao organizerEntityDao;
    private OrganizerEntityDao organizerEntityDao = new OrganizerEntityDao();

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

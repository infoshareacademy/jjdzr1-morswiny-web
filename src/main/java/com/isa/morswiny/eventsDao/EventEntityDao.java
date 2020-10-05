package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.EventEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventEntityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save (EventEntity eventEntity){
        entityManager.persist(eventEntity);
    }

}

package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.TicketEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@ApplicationScoped
public class TicketEntityDao implements Dao<TicketEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TicketEntity ticketEntity) {
        entityManager.persist(ticketEntity);
    }

    @Override
    public TicketEntity update(TicketEntity ticketEntity) {

        return entityManager.merge(ticketEntity);
    }

    @Override
    public void delete(TicketEntity ticketEntity) {
        entityManager.remove(ticketEntity);
    }

    @Override
    public Optional<TicketEntity> find(Integer id) {
        return Optional.ofNullable(entityManager.find(TicketEntity.class, id));
    }
}

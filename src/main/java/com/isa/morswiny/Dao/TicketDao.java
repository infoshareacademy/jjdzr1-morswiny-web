package com.isa.morswiny.Dao;



import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class TicketDao implements Dao<Ticket> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ticket save(Ticket ticket) {
        entityManager.persist(ticket);
        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {

        return entityManager.merge(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        entityManager.remove(ticket);
    }

    @Override
    public Optional<Ticket> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Ticket.class, id));
    }
}

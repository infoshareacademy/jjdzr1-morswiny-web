package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.TicketEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class TicketEntityDao implements Dao<TicketEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(TicketEntity ticketEntity) {
        try{
            entityManager.persist(ticketEntity);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean update(TicketEntity ticketEntity) {
        return false;
    }

    @Override
    public boolean delete(TicketEntity ticketEntity) {
        return false;
    }

    @Override
    public TicketEntity find(Integer id) {
        return null;
    }
}

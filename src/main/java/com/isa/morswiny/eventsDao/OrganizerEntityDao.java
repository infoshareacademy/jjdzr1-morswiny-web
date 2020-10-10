package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.OrganizerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class OrganizerEntityDao implements Dao<OrganizerEntity>, Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(OrganizerEntity organizerEntity) {
        try{
            entityManager.persist(organizerEntity);
            return true;
        }catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(OrganizerEntity organizerEntity) {
        return false;
    }

    @Override
    public boolean delete(OrganizerEntity organizerEntity) {
        return false;
    }

    @Override
    public OrganizerEntity find(Integer id) {
        return null;
    }
}

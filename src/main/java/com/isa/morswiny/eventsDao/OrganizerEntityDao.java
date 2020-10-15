package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.OrganizerEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@RequestScoped
public class OrganizerEntityDao implements Dao<OrganizerEntity>, Serializable {
    @PersistenceContext(unitName = "hibernate_database")
    private EntityManager entityManager;

    @Override
    public void save(OrganizerEntity organizerEntity) {
        entityManager.persist(organizerEntity);
    }

    @Override
    public OrganizerEntity update(OrganizerEntity organizerEntity) {
       return entityManager.merge(organizerEntity);
    }

    @Override
    public void delete(OrganizerEntity organizerEntity) {
        entityManager.remove(organizerEntity);
    }

    @Override
    public Optional<OrganizerEntity> find(Integer id) {
        return Optional.ofNullable(entityManager.find(OrganizerEntity.class, id));

    }

}

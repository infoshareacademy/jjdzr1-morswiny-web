package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.PlaceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;

@ApplicationScoped
public class PlaceEntityDao implements Dao<PlaceEntity>, Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void save(PlaceEntity placeEntity) {
        entityManager.persist(placeEntity);
    }

    @Override
    public PlaceEntity update(PlaceEntity placeEntity) {

        return entityManager.merge(placeEntity);
    }

    @Override
    public void delete(PlaceEntity placeEntity) {
        entityManager.remove(placeEntity);
    }

    @Override
    public Optional<PlaceEntity> find(Integer id) {

        return Optional.ofNullable(entityManager.find(PlaceEntity.class, id));
    }
}

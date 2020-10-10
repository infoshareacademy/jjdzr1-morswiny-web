package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.PlaceEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class PlaceEntityDao implements Dao <PlaceEntity>, Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public boolean save(PlaceEntity placeEntity) {
        try {entityManager.persist(placeEntity);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(PlaceEntity placeEntity) {
        return false;
    }

    @Override
    public boolean delete(PlaceEntity placeEntity) {
        return false;
    }

    @Override
    public PlaceEntity find(Integer id) {
        return null;
    }
}

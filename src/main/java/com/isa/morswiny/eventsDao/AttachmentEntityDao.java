package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.AttachmentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@ApplicationScoped
public class AttachmentEntityDao implements Dao<AttachmentEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(AttachmentEntity attachmentEntity) {
        try {
            entityManager.persist(attachmentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public boolean update(AttachmentEntity attachmentEntity) {
        return false;
    }

    @Override
    public boolean delete(AttachmentEntity attachmentEntity) {
        return false;
    }

    @Override
    public AttachmentEntity find(Integer id) {
        return null;
    }
}

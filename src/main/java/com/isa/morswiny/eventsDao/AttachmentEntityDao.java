package com.isa.morswiny.eventsDao;

import com.isa.morswiny.model.AttachmentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;


@ApplicationScoped
public class AttachmentEntityDao implements Dao<AttachmentEntity>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AttachmentEntity attachmentEntity) {
        entityManager.persist(attachmentEntity);
    }


    @Override
    public AttachmentEntity update(AttachmentEntity attachmentEntity) {
        return entityManager.merge(attachmentEntity);

    }

    @Override
    public void delete(AttachmentEntity attachmentEntity) {
        entityManager.remove(attachmentEntity);

    }

    @Override
    public Optional<AttachmentEntity> find(Integer id) {
        return Optional.ofNullable(entityManager.find(AttachmentEntity.class, id));
    }
}

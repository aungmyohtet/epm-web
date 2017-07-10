package com.zipc.epm.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.zipc.epm.entity.MailCount;
import com.zipc.epm.repository.MailCountRepository;

@Repository
public class MailCountRepositoryImpl implements MailCountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<MailCount> findAll() {
        return entityManager.createQuery("select m from MailCount m", MailCount.class).getResultList();
    }

    @Override
    public void delete(MailCount mailCount) {
        entityManager.remove(mailCount);
    }

}

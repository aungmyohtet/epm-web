package com.zipc.epm.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zipc.epm.entity.AlertWordCountSetting;
import com.zipc.epm.repository.AlertWordCountSettingRepository;

@Repository
public class AlertWordCountSettingRepositoryImpl implements AlertWordCountSettingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(AlertWordCountSetting alertWordCountSetting) {
        entityManager.persist(alertWordCountSetting);
    }

    @Override
    public List<AlertWordCountSetting> findAll() {
        return entityManager.createQuery("SELECT a FROM AlertWordCountSetting a", AlertWordCountSetting.class).getResultList();
    }

    @Override
    public AlertWordCountSetting findById(int id) {
        return entityManager.find(AlertWordCountSetting.class, id);
    }

    @Override
    public AlertWordCountSetting findByName(String name) {
        Query query = entityManager.createQuery("from AlertWordCountSetting setting where setting.name=:name", AlertWordCountSetting.class);
        query.setParameter("name", name);
        AlertWordCountSetting setting = null;
        try {
            setting = (AlertWordCountSetting) query.getSingleResult();
        } catch (NoResultException e) {

        }
        return setting;
    }

    @Override
    public void update(AlertWordCountSetting alertWordCountSetting) {
        entityManager.merge(alertWordCountSetting);
    }

    @Override
    public void delete(AlertWordCountSetting alertWordCountSetting) {
        entityManager.remove(alertWordCountSetting);
    }

}

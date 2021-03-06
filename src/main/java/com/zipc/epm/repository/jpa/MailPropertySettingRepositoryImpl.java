package com.zipc.epm.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.zipc.epm.entity.MailPropertySetting;
import com.zipc.epm.repository.MailPropertySettingRepository;

@Repository
public class MailPropertySettingRepositoryImpl implements MailPropertySettingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(MailPropertySetting mailPropertySetting) {
        entityManager.persist(mailPropertySetting);
    }

    @Override
    public List<MailPropertySetting> findAll() {
        return entityManager.createQuery("select m from MailPropertySetting m", MailPropertySetting.class).getResultList();
    }

    @Override
    public MailPropertySetting findById(int id) {
        return entityManager.find(MailPropertySetting.class, id);
    }

    @Override
    public void update(MailPropertySetting mailPropertySetting) {
        entityManager.merge(mailPropertySetting);
    }

    @Override
    public void delete(int mailPropertyKeyId, int mailAddressId) {
        Query query = entityManager.createQuery("delete from MailPropertySetting m where m.mailPropertyKey.id = :mailPropertyKeyId and m.mailAddress.id =:mailAddressId");
        query.setParameter("mailPropertyKeyId", mailPropertyKeyId);
        query.setParameter("mailAddressId", mailAddressId);
        query.executeUpdate();
    }

    @Override
    public void delete(int mailPropertyKeyId) {
        Query query = entityManager.createQuery("delete from MailPropertySetting m where m.mailPropertyKey.id = :mailPropertyKeyId");
        query.setParameter("mailPropertyKeyId", mailPropertyKeyId);
        query.executeUpdate();
    }

    @Override
    public void delete(MailPropertySetting setting) {
        Query query = entityManager.createQuery("delete from MailPropertySetting m where m.mailAddress.id = :id ");
        query.setParameter("id", setting.getMailAddress().getId());
        query.executeUpdate();
    }

    @Override
    public MailPropertySetting findByIds(int mailPropertyKeyId, int mailAddressId) {
        String query = "SELECT m from MailPropertySetting m WHERE m.mailPropertyKey.id = " + mailPropertyKeyId + "AND m.mailAddress.id = " + mailAddressId;
        return entityManager.createQuery(query, MailPropertySetting.class).getSingleResult();
    }

}

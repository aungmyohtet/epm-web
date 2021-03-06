package com.zipc.epm.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.zipc.epm.entity.MailCountListener;
import com.zipc.epm.repository.MailCountListenerRepository;

@Repository
public class MailCountListenerRepositoryImpl implements MailCountListenerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(MailCountListener mailCountListener) {
        entityManager.persist(mailCountListener);
    }

    @Override
    public List<MailCountListener> findAll() {
        return entityManager.createQuery("select m from MailCountListener m", MailCountListener.class).getResultList();
    }

    @Override
    public MailCountListener findById(int id) {
        return entityManager.find(MailCountListener.class, id);
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from MailCountListener m where m.mailAddress.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public void delete(MailCountListener listener) {
        entityManager.remove(listener);
    }
}

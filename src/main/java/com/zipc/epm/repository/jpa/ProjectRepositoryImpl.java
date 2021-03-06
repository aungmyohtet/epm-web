package com.zipc.epm.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zipc.epm.entity.MailAddress;
import com.zipc.epm.entity.Project;
import com.zipc.epm.repository.ProjectRepository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Project project) {
        if (project.getId() == null) {
            entityManager.persist(project);
        } else {
            entityManager.merge(project);
        }
    }

    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("select p from Project p", Project.class).getResultList();
    }

    @Override
    public Project findById(int id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public Project findByName(String name) {
        Project project = null;
        try {
            Query q = entityManager.createQuery("select p from Project p where p.name=?");
            q.setParameter(1, name);
            project = (Project) q.getSingleResult();
        } catch (NoResultException e) {

        }
        if (project != null) {
            System.out.println("project name is " + project.getName());
        }
        return project;
    }

    @Override
    public void update(Project project) {
        Query query = entityManager.createQuery("update Project p set p.name=:name where p.id=:id");
        query.setParameter("id", project.getId());
        query.setParameter("name", project.getName());
        query.executeUpdate();
        // entityManager.merge(project);
    }

    @Override
    public void delete(Project project) {
        entityManager.remove(project);
    }

    @Override
    public Project isExistsMailAddress(MailAddress mailAddress, Project project) {
        Project proj = null;
        try {
            Query q = entityManager.createQuery("SELECT p FROM Project p LEFT JOIN p.mailAddresses m WHERE p.id = :pId AND m.id = :mId");
            q.setParameter("pId", project.getId());
            q.setParameter("mId", mailAddress.getId());
            proj = (Project) q.getSingleResult();
        } catch (NoResultException e) {

        }
        if (proj != null) {
            System.out.println("project name is " + proj.getName());
        }
        return proj;
    }
}

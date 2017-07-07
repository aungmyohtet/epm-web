package com.zipc.epm.web.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.zipc.epm.web.entity.UserRole;
import com.zipc.epm.web.repository.UserRoleRepository;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(UserRole userRole) {
        entityManager.persist(userRole);
    }

}

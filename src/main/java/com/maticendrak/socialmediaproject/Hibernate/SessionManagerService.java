package com.maticendrak.socialmediaproject.Hibernate;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class SessionManagerService {
    @PersistenceContext
    private EntityManager entityManager;

    public <R> NativeQuery<R> createNativeQuery(String sqlString, Class<R> resultClass) {
        return getSession().createNativeQuery(sqlString, resultClass);
    }

    public NativeQuery createNativeQuery(String sqlString) {
        return getSession().createNativeQuery(sqlString);
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}

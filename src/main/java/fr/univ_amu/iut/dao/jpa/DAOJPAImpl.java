package fr.univ_amu.iut.dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

class DAOJPAImpl {
    protected final EntityManager entityManager;

    DAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    <T> List<T> findImpl(Class<T> entityClass, String queryName) {
        TypedQuery<T> query = entityManager.createNamedQuery(queryName, entityClass);
        return query.getResultList();
    }

    <T, U> List<T> findByImpl(Class<T> entityClass, String queryName, String parameterName, U parameterValue) {
        TypedQuery<T> query = entityManager.createNamedQuery(queryName, entityClass);
        query.setParameter(parameterName, parameterValue);
        return query.getResultList();
    }

    <T> T getByIdImpl(Class<T> entityClass, Object key) {
        return entityManager.find(entityClass, key);
    }

    void insertImpl(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    void updateImpl(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }

    void deleteImpl(Object obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

}

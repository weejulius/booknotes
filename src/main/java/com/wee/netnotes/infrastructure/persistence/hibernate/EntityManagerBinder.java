package com.wee.netnotes.infrastructure.persistence.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityManagerBinder {
    private final static EntityManagerFactory ef = Persistence
            .createEntityManagerFactory("booknote");
    private final static ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();

    public EntityManager entityManager() {
        EntityManager em = emThreadLocal.get();
        if (em == null || !em.isOpen()) {
            em = ef.createEntityManager();
            emThreadLocal.set(em);
        }
        return em;
    }

    public EntityTransaction transaction() {
        return entityManager().getTransaction();
    }

    public void rollback() {
        if (transaction().isActive())
            transaction().rollback();
    }

    public void closeEntityManager() {
        EntityManager em = emThreadLocal.get();
        emThreadLocal.set(null);
        if (em != null) {
            em.close();
        }
    }

    public void begin() {
        beginTransaction();
    }

    public void close() {
        commitTransaction();
        closeEntityManager();
    }

    public void beginTransaction() {
        if (!transaction().isActive())
            transaction().begin();
    }

    public void commitTransaction() {
        transaction().commit();
    }

    public Query createQuery(String query) {
        return entityManager().createQuery(query);
    }
}
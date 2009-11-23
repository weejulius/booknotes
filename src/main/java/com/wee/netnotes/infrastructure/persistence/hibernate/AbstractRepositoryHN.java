package com.wee.netnotes.infrastructure.persistence.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractRepositoryHN {

    private EntityManagerBinder emb;

    public EntityManager entityManager() {
        return emb.entityManager();
    }

    public void closeEntityManager() {
        emb.closeEntityManager();
    }

    public void beginTransaction() {
        emb.beginTransaction();
    }

    public void commitTransaction() {
        emb.commitTransaction();
    }

    public Query createQuery(String query) {
        return emb.createQuery(query);
    }

    @SuppressWarnings(value = "unchecked")
    public Object find(Class clazz, Object primaryKey) {
        return entityManager().find(clazz, primaryKey);
    }
}

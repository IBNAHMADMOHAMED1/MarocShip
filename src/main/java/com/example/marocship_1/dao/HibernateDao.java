package com.example.marocship_1.dao;
import com.example.marocship_1.utlis.JpaService;
import jakarta.persistence.Table;
import org.hibernate.SessionFactory;
import  com.example.marocship_1.entity.Person;

import java.io.Serializable;
import java.util.List;

public abstract class HibernateDao<T extends Serializable> {
    private Class<T> clazz;
    private static final JpaService jpaService = JpaService.getInstance();

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(long id) {
        return (T) jpaService.runInTransaction(entityManager -> {
            return entityManager.find(clazz, id);
        });
    }
    public T create(T entity) {
        return (T) jpaService.runInTransaction(entityManager -> {
            entityManager.persist(entity);
            return entity;
        });
    }
    public T update(T entity) {
        return (T) jpaService.runInTransaction(entityManager -> {
            entityManager.merge(entity);
            return entity;
        });
    }

    public Boolean delete(T entity) {
        return (Boolean) jpaService.runInTransaction(entityManager -> {
            entityManager.remove(entity);
            return true;
        });
    }

    public T getByField(String fieldName, Object value) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();
        return (T) jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("from " + tableName + " where " + fieldName + " = :value", clazz)
                    .setParameter("value", value)
                    .getSingleResult();
        });
    }




}

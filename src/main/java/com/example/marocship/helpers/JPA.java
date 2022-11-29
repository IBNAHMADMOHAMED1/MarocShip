package com.example.marocship.helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class JPA {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static void wrap(Consumer<EntityManager> action){
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }catch (RuntimeException re){
            tx.rollback();
            throw re;
        }finally {
            em.close();
        }
    }

    public static void wrap(EntityManager em,Consumer<EntityManager> action){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }catch (RuntimeException re){
            tx.rollback();
            throw re;
        }finally {
            em.close();
        }
    }

    public static EntityManagerFactory entityManagerFactory() {
        return emf;
    }

    public static EntityManager entityManager() {
        return emf.createEntityManager();
    }
}
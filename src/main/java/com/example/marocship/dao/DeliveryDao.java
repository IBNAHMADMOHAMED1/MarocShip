package com.example.marocship.dao;

import com.example.marocship.entities.Delivery;
import com.example.marocship.helpers.JPA;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

@Named
@ApplicationScoped
public class DeliveryDao implements Dao<Delivery>{
    @Override
    public Delivery get(long id) {
        return JPA.entityManager().find(Delivery.class,id);
    }

    @Override
    public List<Delivery> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT m FROM Delivery m");
        return query.getResultList();
    }

    @Override
    public void save(Delivery delivery) {
        JPA.wrap(entityManager -> entityManager.persist(delivery));
    }

    @Override
    public void update(Delivery delivery, String[] params) {
        System.out.println("Please consider to use the overloaded update.");
    }

    public void update(Delivery delivery, Consumer<Delivery>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(delivery);
        }
        JPA.wrap(entityManager -> entityManager.merge(delivery));
    }

    @Override
    public void delete(Delivery delivery) {
        EntityManager em = JPA.entityManager();
        Delivery deliveryToRemove = em.merge(delivery);
        JPA.wrap(em,entityManager -> entityManager.remove(deliveryToRemove));
    }
}

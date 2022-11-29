package com.example.marocship.dao;

import com.example.marocship.entities.Vehicle;
import com.example.marocship.helpers.JPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VehicleDao implements Dao<Vehicle>{
    @Override
    public Vehicle get(long id) {
        return JPA.entityManager().find(Vehicle.class, id);
    }

    @Override
    public List<Vehicle> getAll() {
        return JPA.entityManager().createQuery("from Vehicle ", Vehicle.class).getResultList();
    }

    @Override
    public void save(Vehicle vehicle) {
        JPA.wrap(entityManager -> entityManager.persist(vehicle));
    }

    @Override
    public void update(Vehicle vehicle, String[] setters) {
//        for (int i = 0; i < setters.length; i++) {
//            setters[i].accept(vehicle);
//        }
//        JPA.wrap(entityManager -> entityManager.merge(vehicle));
    }

    @Override
    public void delete(Vehicle vehicle) {
        EntityManager em = JPA.entityManager();
        Vehicle vehicleToRemove = em.merge(vehicle);
        JPA.wrap(em,entityManager -> entityManager.remove(vehicleToRemove));
    }
}

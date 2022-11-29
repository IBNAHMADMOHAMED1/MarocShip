package com.example.marocship.dao;

import com.example.marocship.entities.VehicleCategory;
import com.example.marocship.helpers.JPA;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

@Named
@ApplicationScoped
public class VehicleCatDao implements Dao<VehicleCategory>{
    @Override
    public VehicleCategory get(long id) {
        return JPA.entityManager().find(VehicleCategory.class,id);
    }

    @Override
    public List<VehicleCategory> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT v FROM VehicleCategory v");
        return query.getResultList();
    }

    @Override
    public void save(VehicleCategory vehicleCategory) {
        JPA.wrap(entityManager -> entityManager.persist(vehicleCategory));
    }

    @Override
    public void update(VehicleCategory vehicleCategory, String[] params) {
        System.out.println("Please consider to use the overloaded update.");
    }

    public void update(VehicleCategory vehicleCategory, Consumer<VehicleCategory>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(vehicleCategory);
        }
        JPA.wrap(entityManager -> entityManager.merge(vehicleCategory));
    }

    @Override
    public void delete(VehicleCategory vehicleCategory) {
        EntityManager em = JPA.entityManager();
        VehicleCategory vehicleCategoryToRemove = em.merge(vehicleCategory);
        JPA.wrap(em,entityManager -> entityManager.remove(vehicleCategoryToRemove));
    }
}

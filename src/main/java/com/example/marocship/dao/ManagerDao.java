package com.example.marocship.dao;

import com.example.marocship.entities.Manager;
import com.example.marocship.helpers.JPA;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;
@Named
@ApplicationScoped
public class ManagerDao implements Dao<Manager>{
    @Override
    public Manager get(long id) {
        return JPA.entityManager().find(Manager.class,id);
    }

    @Override
    public List<Manager> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT m FROM Manager m");
        return query.getResultList();
    }

    @Override
    public void save(Manager manager) {
        JPA.wrap(entityManager -> entityManager.persist(manager));
    }

    @Override
    public void update(Manager manager, String[] params) {
        System.out.println("Please consider to use the overloaded update.");
    }

    public void update(Manager manager, Consumer<Manager>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(manager);
        }
        JPA.wrap(entityManager -> entityManager.merge(manager));
    }

    @Override
    public void delete(Manager manager) {
        EntityManager em = JPA.entityManager();
        Manager managerToRemove = em.merge(manager);
        JPA.wrap(em,entityManager -> entityManager.remove(managerToRemove));
    }

    public Manager managerExist(String email,String password){
        Query query = JPA.entityManager().createQuery("SELECT m FROM Manager m WHERE m.email = :email AND m.password = :password");

        query.setParameter("email",email);
        query.setParameter("password",password);

        List<Manager> managers = query.getResultList();

        return managers.size() > 0 ? managers.get(0) : null;
    }
}

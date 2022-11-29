package com.example.marocship.dao;

import com.example.marocship.entities.Manager;
import com.example.marocship.entities.Person;
import com.example.marocship.helpers.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

public class PersonDao<P extends Person>{

    public Person get(long id,Class<P> clazz) {
        return JPA.entityManager().find(clazz,id);
    }

    public List<Person> getAll(Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p");
        return query.getResultList();
    }

    public void save(Person person) {
        JPA.wrap(entityManager -> entityManager.persist(person));
    }

    public void update(Person person, Consumer<Person>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(person);
        }
        JPA.wrap(entityManager -> entityManager.merge(person));
    }

    public void delete(Person person) {
        EntityManager em = JPA.entityManager();
        Person personToBeRemoved = em.merge(person);
        JPA.wrap(em,entityManager -> entityManager.remove(personToBeRemoved));
    }

    public Person userExist(String email, String password,Class clazz){
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p WHERE p.email = :email AND p.password = :password");

        query.setParameter("email",email);
        query.setParameter("password",password);

        List<Person> person = query.getResultList();

        return person.size() > 0 ? person.get(0) : null;
    }
}

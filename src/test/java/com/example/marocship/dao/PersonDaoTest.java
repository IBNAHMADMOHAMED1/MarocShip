package com.example.marocship.dao;

import com.example.marocship.entities.Manager;
import com.example.marocship.entities.Person;
import org.junit.jupiter.api.Test;


import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {

    @Test
    void get() {
        PersonDao personDao = new PersonDao();
        assertNotNull(personDao.get(1, Manager.class));
    }


    @Test
    void save() {
        Manager manager = new Manager();
        manager.setEmail("test.person.dao@junit.com");
        manager.setPassword("junit1234");
        manager.setUsername("TEST Junit");
        new PersonDao().save(manager);

        assertNotNull(manager.getPersonId());
    }

    @Test
    void update() {
        Manager manager = new Manager();
        manager.setEmail("should.be.updated.person.dao@junit.com");
        manager.setPassword("junit1234");
        manager.setUsername("TEST Junit");

        PersonDao personDao = new PersonDao();
        personDao.save(manager);

        Consumer<Manager>[] setters = new Consumer[1];
        setters[0] = manager1 -> manager1.setEmail("updated.person.dao@junit.com");

        personDao.update(manager,setters);

        assertEquals(manager.getEmail(),"updated.person.dao@junit.com");
    }

    @Test
    void delete() {
        Person person = new Manager();

        person.setEmail("should.be.deleted.person.dao@junit.com");
        person.setPassword("junit1234");
        person.setUsername("TEST Junit");

        PersonDao personDao = new PersonDao();
        personDao.delete(person);

        assertNull(personDao.get(person.getPersonId(),Manager.class));
    }
}
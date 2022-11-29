package com.example.marocship.dao;
import static org.junit.jupiter.api.Assertions.*;

import com.example.marocship.entities.Manager;
import com.example.marocship.helpers.JPA;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

class ManagerDaoTest {

    @Test
    void returnNotNullWhenIdExist() {
        Manager manager = new Manager();
        manager.setEmail("test@junit.com");
        manager.setPassword("test1234");
        manager.setUsername("TEST Junit");

        new ManagerDao().save(manager);

        assertNotNull(new ManagerDao().get(manager.getPersonId()));
    }

    @Test
    void returnNullWhenIdDoesNotExist() {
        assertNull(new ManagerDao().get(0));
    }

    @Test
    void saveManagerWhenAllFieldsAreSet() {
        Manager manager = new Manager();
        manager.setEmail("test@junit.com");
        manager.setPassword("test1234");
        manager.setUsername("TEST Junit");

        new ManagerDao().save(manager);

        assertNotNull(manager.getPersonId());

    }

    @Test
    void throwExceptionWhenOneOfTheRequiredFieldsNotSet(){
        Manager manager = new Manager();
        assertThrows(PersistenceException.class,() -> new ManagerDao().save(manager));
    }

    @Test
    void update() {
        Manager manager = new Manager();
        manager.setEmail("test@junit.com");
        manager.setPassword("test1234");
        manager.setUsername("TEST Junit");

        ManagerDao managerDao = new ManagerDao();
        managerDao.save(manager);

        Consumer<Manager>[] setters = new Consumer[1];
        setters[0] = (m) -> m.setEmail("updated@junit.com");

        managerDao.update(manager,setters);

        assertEquals("updated@junit.com",manager.getEmail());
    }

    @Test
    void delete() {
        Manager manager = new Manager();
        manager.setEmail("to.be.deleted@junit.com");
        manager.setPassword("test1234");
        manager.setUsername("TEST Junit");

        ManagerDao managerDao = new ManagerDao();
        managerDao.save(manager);

        managerDao.delete(manager);

        assertNull(managerDao.get(manager.getPersonId()));
    }
}
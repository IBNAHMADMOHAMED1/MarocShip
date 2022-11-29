package com.example.marocship.controllers;

import com.example.marocship.dao.PersonDao;
import com.example.marocship.entities.DeliveryManager;
import com.example.marocship.entities.Driver;
import com.example.marocship.entities.Person;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class DriversController implements Serializable {

    PersonDao personDao;

    private List<Person> deliveryManager;

    public List<Person> getDeliveryManager() {
        return new PersonDao<DeliveryManager>().getAll(DeliveryManager.class);
    }

    public void confirmDeliveryByDriver(long id){

    }
}

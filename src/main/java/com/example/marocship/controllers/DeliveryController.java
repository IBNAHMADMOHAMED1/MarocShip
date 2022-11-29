package com.example.marocship.controllers;


import com.example.marocship.beans.Auth;
import com.example.marocship.dao.DeliveryDao;
import com.example.marocship.dao.VehicleCatDao;
import com.example.marocship.entities.Delivery;
import com.example.marocship.entities.Driver;
import com.example.marocship.entities.Vehicle;
import com.example.marocship.entities.VehicleCategory;
import com.example.marocship.helpers.Enum;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class DeliveryController {
    @Inject
    VehicleCatDao vehicleCatDao;

    @Inject
    DeliveryDao deliveryDao;

    @Inject
    com.example.marocship.beans.Delivery deliveryBean;

    @Inject
    Auth auth;
    private List<VehicleCategory> vehicleCategories;
    private List<Delivery> deliveries;
    private List<Delivery> deliveriesByVehicle;


    @PostConstruct
    public void initialize(){
        this.vehicleCategories = vehicleCatDao.getAll();
        this.deliveries = deliveryDao.getAll();
    }

    public void createDelivery(){
        // input verification /!\
        Delivery delivery = new Delivery();

        delivery.setOrigin(deliveryBean.getOrigin());
        delivery.setDestination(deliveryBean.getDestination());
        delivery.setWeight(deliveryBean.getWeight());
        delivery.setVehicleCatId(deliveryBean.getVehicleCatId());
        delivery.setDeliveryManagerId(auth.getUser().getPersonId());
        delivery.setDriver(null);
        delivery.setStatus(Enum.status.PENDING.toString());
        deliveryBean.removeObject();
        deliveryDao.save(delivery);
    }

    public List<VehicleCategory> getVehicleCategories() {
        return vehicleCategories;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public List<Delivery> getDeliveriesByVehicle() {
        if(auth.getRole().equals(Enum.role.DRIVER.toString())){
            deliveriesByVehicle = (List<Delivery>) ((Driver)auth.getUser()).getVehicle().getVehicleCategory().getDeliveries();
        }
        return deliveriesByVehicle;
    }
}

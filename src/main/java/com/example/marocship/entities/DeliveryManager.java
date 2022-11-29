package com.example.marocship.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "delivery_manager")
public class DeliveryManager extends Person{

    @OneToMany(mappedBy = "deliveryManager")
    Collection<Delivery> deliveries;

    public DeliveryManager() {}

    public DeliveryManager(long personId, String email, String username, String password) {
        super(personId, email, username, password);
    }

    public Collection<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Collection<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}

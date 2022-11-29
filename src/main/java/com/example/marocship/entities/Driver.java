package com.example.marocship.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Driver extends Person{

    @Column(name = "vehicle_id")
    private long vehicleId;

    @OneToOne
    @JoinColumn(name = "vehicle_id",insertable = false,updatable = false)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "driver")
    private Collection<Delivery> deliveries;

    public Driver() {}

    public Driver(long personId, String email, String username, String password, long vehcileId) {
        super(personId, email, username, password);
        this.vehicleId = vehcileId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Collection<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Collection<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}

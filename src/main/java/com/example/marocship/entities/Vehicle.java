package com.example.marocship.entities;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String name;

    @Column(name = "vehicle_cat_id")
    private long vehicleCatId;

    @ManyToOne
    @JoinColumn(name = "vehicle_cat_id",insertable = false,updatable = false)
    private VehicleCategory vehicleCategory;

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVehicleCatId() {
        return vehicleCatId;
    }

    public void setVehicleCatId(long vehicleCatId) {
        this.vehicleCatId = vehicleCatId;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

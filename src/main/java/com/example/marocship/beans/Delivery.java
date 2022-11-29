package com.example.marocship.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Delivery {
    private String origin;
    private String destination;
    private long vehicleCatId;
    private float weight;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getVehicleCatId() {
        return vehicleCatId;
    }

    public void setVehicleCatId(long vehicleCatId) {
        this.vehicleCatId = vehicleCatId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void removeObject(){
        this.setDestination(null);
        this.setOrigin(null);
        this.setWeight(0);
        this.setVehicleCatId(0);
    }

}

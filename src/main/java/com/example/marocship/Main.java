package com.example.marocship;
import com.example.marocship.dao.PersonDao;
import com.example.marocship.entities.Delivery;
import com.example.marocship.entities.DeliveryManager;
import jakarta.persistence.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(new PersonDao<>().getAll(DeliveryManager.class));
    }
}

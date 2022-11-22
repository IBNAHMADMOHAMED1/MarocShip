package com.example.marocship_1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Livraison {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ville_depart", nullable = false)
    private LocalDate villeDepart;

    @Column(name = "ville_arrivee", nullable = false)
    private LocalDate villeArrivee;

    @Column(name = "prix", nullable = false)
    private Float prix;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "poids", nullable = false)
    private Double poids;

    @Column(name = "isSelect", nullable = false)
    private Boolean isSelect = false;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(LocalDate villeDepart) {
        this.villeDepart = villeDepart;
    }

    public LocalDate getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(LocalDate villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
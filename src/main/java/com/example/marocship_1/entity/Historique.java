package com.example.marocship_1.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "livraison_id")
    private Integer livraisonId;

    @Column(name = "chauffeur_id")
    private Integer chauffeurId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLivraisonId() {
        return livraisonId;
    }

    public void setLivraisonId(Integer livraisonId) {
        this.livraisonId = livraisonId;
    }

    public Integer getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(Integer chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
package com.example.marocship_1.entity;

import jakarta.persistence.*;

@Entity
public class Chauffeur {
    @Id
    @Column(name = "id_Chauffeur", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Chauffeur", nullable = false)
    private Person person;

    @Column(name = "point_fidelite", nullable = false)
    private Integer pointFidelite;

    @Column(name = "vehicule_id")
    private Integer vehiculeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getPointFidelite() {
        return pointFidelite;
    }

    public void setPointFidelite(Integer pointFidelite) {
        this.pointFidelite = pointFidelite;
    }

    public Integer getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(Integer vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

}
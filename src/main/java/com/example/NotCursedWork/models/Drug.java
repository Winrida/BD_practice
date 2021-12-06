package com.example.NotCursedWork.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer Pills, Antibiotics, Vitamins;

    public Drug() {
    }

    public Drug(Integer pills, Integer antibiotics, Integer vitamins) {
        Pills = pills;
        Antibiotics = antibiotics;
        Vitamins = vitamins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPills() {
        return Pills;
    }

    public void setPills(Integer pills) {
        Pills = pills;
    }

    public Integer getAntibiotics() {
        return Antibiotics;
    }

    public void setAntibiotics(Integer antibiotics) {
        Antibiotics = antibiotics;
    }

    public Integer getVitamins() {
        return Vitamins;
    }

    public void setVitamins(Integer vitamins) {
        Vitamins = vitamins;
    }
}

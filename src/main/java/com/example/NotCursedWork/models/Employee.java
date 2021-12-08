package com.example.NotCursedWork.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String WName, Workplace, WTelephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWName() {
        return WName;
    }

    public void setWName(String WName) {
        this.WName = WName;
    }

    public String getWorkplace() {
        return Workplace;
    }

    public void setWorkplace(String Workplace) {
        this.Workplace = Workplace;
    }

    public String getWTelephone() {
        return WTelephone;
    }

    public void setWTelephone(String WTelephone) {
        this.WTelephone = WTelephone;
    }

    public Employee() {
    }

    public Employee(String WName, String Workplace, String WTelephone) {
        this.WName = WName;
        this.Workplace = Workplace;
        this.WTelephone = WTelephone;
    }
}

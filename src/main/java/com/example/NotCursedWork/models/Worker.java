package com.example.NotCursedWork.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String WName, WSurname, WTelephone;

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

    public String getWSurname() {
        return WSurname;
    }

    public void setWSurname(String WSurname) {
        this.WSurname = WSurname;
    }

    public String getWTelephone() {
        return WTelephone;
    }

    public void setWTelephone(String WTelephone) {
        this.WTelephone = WTelephone;
    }

    public Worker() {
    }

    public Worker(String WName, String WSurname, String WTelephone) {
        this.WName = WName;
        this.WSurname = WSurname;
        this.WTelephone = WTelephone;
    }
}

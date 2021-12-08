package com.example.NotCursedWork.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CName, Guitar, CTelephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getGuitar() {
        return Guitar;
    }

    public void setGuitar(String Guitar) {
        this.Guitar = Guitar;
    }

    public String getCTelephone() {
        return CTelephone;
    }

    public void setCTelephone(String CTelephone) {
        this.CTelephone = CTelephone;
    }

    public Client() {
    }

    public Client(String CName, String Guitar, String CTelephone) {
        this.CName = CName;
        this.Guitar = Guitar;
        this.CTelephone = CTelephone;
    }
}

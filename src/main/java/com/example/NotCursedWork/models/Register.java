package com.example.NotCursedWork.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer Hardware;
    private boolean PDevices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHardware() {
        return Hardware;
    }

    public void setHardware(Integer hardware) {
        Hardware = hardware;
    }

    public boolean isPDevices() {
        return PDevices;
    }

    public void setPDevices(boolean PDevices) {
        this.PDevices = PDevices;
    }

    public Register() {
    }

    public Register(Integer hardware, boolean PDevices) {
        Hardware = hardware;
        this.PDevices = PDevices;
    }
}

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
    private String Materials;
    private String RepairTools;
    private boolean RepairStatus;
    private Long OrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterials() {
        return Materials;
    }

    public void setMaterials(String materials) {
        Materials = materials;
    }

    public String getRepairTools() {
        return RepairTools;
    }

    public void setRepairTools(String repairTools) {
        RepairTools = repairTools;
    }

    public boolean isRepairStatus() {
        return RepairStatus;
    }

    public void setRepairStatus(boolean repairStatus) {
        RepairStatus = repairStatus;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public Register() {
    }

    public Register(String materials, String repairTools, boolean repairStatus, Long orderId) {
        Materials = materials;
        RepairTools = repairTools;
        RepairStatus = repairStatus;
        OrderId = orderId;
    }
}

package com.example.NotCursedWork.models;

import javax.persistence.*;

@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double Price;
    private  String Diagnostics;

    public Order1(String diagnostics) {
        Diagnostics = diagnostics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDiagnostics() {
        return Diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        Diagnostics = diagnostics;
    }

    public Order1() {
    }

    public Order1(Long id, double price, String diagnostics) {
        this.id = id;
        Price = price;
        Diagnostics = diagnostics;
    }
}
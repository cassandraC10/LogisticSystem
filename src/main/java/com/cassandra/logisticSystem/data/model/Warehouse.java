package com.cassandra.logisticSystem.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "warehouse")
    private List<Product> inventory;

    @ManyToOne
    private Employee manager;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void setInventory(List<Product> inventory) {
        this.inventory = inventory;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}

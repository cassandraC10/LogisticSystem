package com.cassandra.logisticSystem.data.model;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Table
public class Carrier {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactInformation;
    private String shippingMethodsSupported;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setShippingMethodsSupported(String shippingMethodsSupported) {
        this.shippingMethodsSupported = shippingMethodsSupported;
    }
}


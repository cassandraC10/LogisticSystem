package com.cassandra.logisticSystem.service;

import com.cassandra.logisticSystem.data.model.Shipment;
import com.cassandra.logisticSystem.data.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository){this.shipmentRepository = shipmentRepository;}

    public List<Shipment> getAllShipments() {return shipmentRepository.findAll();}

    public Shipment getShipmentById(Long id){
        return shipmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Shipment with id: " + id + "not found"));
    }

    public Shipment saveOrUpdateShipment(Shipment shipment) {return shipmentRepository.save(shipment);}

    public void deleteShipment(Long id){shipmentRepository.deleteById(id);}
}

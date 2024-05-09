package com.cassandra.logisticSystem.controller;

import com.cassandra.logisticSystem.data.model.Shipment;
import com.cassandra.logisticSystem.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments(){
        List<Shipment> shipments = shipmentService.getAllShipments();
        return new ResponseEntity<>(shipments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id){
        Shipment shipment = shipmentService.getShipmentById(id);
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Shipment> createOrUpdateShipment(@RequestBody Shipment shipment){
        Shipment updaatedShipment = shipmentService.saveOrUpdateShipment(shipment);
        return new ResponseEntity<>(updaatedShipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id){
        shipmentService.deleteShipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

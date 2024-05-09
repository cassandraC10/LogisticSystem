package com.cassandra.logisticSystem.controller;

import com.cassandra.logisticSystem.data.model.Carrier;
import com.cassandra.logisticSystem.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    private final CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @GetMapping
    public ResponseEntity<List<Carrier>> getAllCarriers() {
        List<Carrier> carriers = carrierService.getAllCarriers();
        return new ResponseEntity<>(carriers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable Long id) {
        Carrier carrier = carrierService.getCarrierById(id);
        return new ResponseEntity<>(carrier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carrier> createOrUpdateCarrier(@RequestBody Carrier carrier) {
        Carrier savedCarrier = carrierService.saveOrUpdateCarrier(carrier);
        return new ResponseEntity<>(savedCarrier, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrier(@PathVariable Long id) {
        carrierService.deleteCarrier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

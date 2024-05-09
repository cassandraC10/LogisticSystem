package com.cassandra.logisticSystem.controller;

import com.cassandra.logisticSystem.data.model.DeliveryRoute;
import com.cassandra.logisticSystem.service.DeliveryRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveryroute")
public class DeliveryRouteController {
    private final DeliveryRouteService deliveryRouteService;

    @Autowired
    public DeliveryRouteController(DeliveryRouteService deliveryRouteService) {
        this.deliveryRouteService = deliveryRouteService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryRoute>> getAllDeliveryRoute() {
        List<DeliveryRoute> deliveryRoutes = deliveryRouteService.getAllDeliveryRoutes();
        return new ResponseEntity<>(deliveryRoutes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryRoute> getDeliveryRouteById(@PathVariable Long id) {
        DeliveryRoute deliveryRoute = deliveryRouteService.getDeliveryRouteById(id);
        return new ResponseEntity<>(deliveryRoute, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DeliveryRoute> createOrUpdateDeliveryRoute(@RequestBody DeliveryRoute deliveryRoute) {
        DeliveryRoute updateDeliveryRoute = deliveryRouteService.saveOrUpdateDeliveryRoute(deliveryRoute);
        return new ResponseEntity<>(updateDeliveryRoute, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryRoute(@PathVariable Long id) {
        deliveryRouteService.deleteDeliveryRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

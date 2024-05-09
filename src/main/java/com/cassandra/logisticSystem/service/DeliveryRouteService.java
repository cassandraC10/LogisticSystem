package com.cassandra.logisticSystem.service;

import com.cassandra.logisticSystem.data.model.DeliveryRoute;
import com.cassandra.logisticSystem.data.repository.DeliveryRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRouteService {
    private final DeliveryRouteRepository deliveryRouteRepository;

    @Autowired
    public DeliveryRouteService(DeliveryRouteRepository deliveryRouteRepository) {
        this.deliveryRouteRepository = deliveryRouteRepository;
    }

    public List<DeliveryRoute> getAllDeliveryRoutes() {
        return deliveryRouteRepository.findAll();
    }

    public DeliveryRoute getDeliveryRouteById(Long id) {
        return deliveryRouteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Route not found with id: " + id));
    }

    public DeliveryRoute saveOrUpdateDeliveryRoute(DeliveryRoute deliveryRoute) {
        return deliveryRouteRepository.save(deliveryRoute);
    }

    public void deleteDeliveryRoute(Long id) {
        deliveryRouteRepository.deleteById(id);
    }
}

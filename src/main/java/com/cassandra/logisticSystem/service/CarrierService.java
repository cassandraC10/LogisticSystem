package com.cassandra.logisticSystem.service;

import com.cassandra.logisticSystem.data.model.Carrier;
import com.cassandra.logisticSystem.data.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrierService {

    private final CarrierRepository carrierRepository;

    @Autowired
    public CarrierService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    public Carrier getCarrierById(Long id) {
        return carrierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrier not found with id: " + id));
    }

    public Carrier saveOrUpdateCarrier(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    public void deleteCarrier(Long id) {
        carrierRepository.deleteById(id);
    }
}


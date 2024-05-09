package com.cassandra.logisticSystem.data.repository;

import com.cassandra.logisticSystem.data.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}


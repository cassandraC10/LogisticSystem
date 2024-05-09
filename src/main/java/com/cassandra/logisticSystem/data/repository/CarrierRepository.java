package com.cassandra.logisticSystem.data.repository;

import com.cassandra.logisticSystem.data.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}


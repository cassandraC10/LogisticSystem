package com.cassandra.logisticSystem.data.repository;

import com.cassandra.logisticSystem.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


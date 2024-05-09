package com.cassandra.logisticSystem.data.repository;
import com.cassandra.logisticSystem.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}

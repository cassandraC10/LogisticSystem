package com.cassandra.logisticSystem.data.repository;
import com.cassandra.logisticSystem.data.model.DeliveryRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRouteRepository extends JpaRepository<DeliveryRoute, Long>{
}

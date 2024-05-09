package com.cassandra.logisticSystem.data.repository;
import com.cassandra.logisticSystem.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

package com.cassandra.logisticSystem.data.repository;
import com.cassandra.logisticSystem.data.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
}

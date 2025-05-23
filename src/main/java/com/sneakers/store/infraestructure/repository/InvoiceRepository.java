package com.sneakers.store.infraestructure.repository;

import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    Optional<InvoiceEntity> getInvoiceByInvoiceNumber(String invoiceNumber);
}

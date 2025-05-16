package com.sneakers.store.infraestructure.repository;

import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

}

package com.sneakers.store.infraestructure.repository;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.infraestructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @EntityGraph(attributePaths = {
            "orders",
            "orders.details",
            "orders.invoice"
    })
    Optional<CustomerEntity> getCustomerByEmail(String email);
}

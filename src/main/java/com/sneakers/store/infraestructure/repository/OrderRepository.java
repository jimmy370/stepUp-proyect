package com.sneakers.store.infraestructure.repository;

import com.sneakers.store.infraestructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

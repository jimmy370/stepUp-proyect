package com.sneakers.store.infraestructure.repository;

import com.sneakers.store.infraestructure.entity.DetailsOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<DetailsOrderEntity, Long> {
}

package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_factura", unique = true, nullable = false)
    private String invoiceNumber;

    @Column(name = "fecha")
    private LocalDateTime issueDate;

    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private OrderEntity order;
}

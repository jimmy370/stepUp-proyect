package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_factura", unique = true, nullable = false)
    private String invoiceNumber;

    @Column(name = "fecha")
    private LocalDateTime issueDate;

    private BigDecimal total;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private OrderEntity order;
}

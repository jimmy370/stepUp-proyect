package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_factura", unique = true, nullable = false)
    private String invoiceNumber;

    @Column(name = "fecha_emision")
    private LocalDateTime issueDate;
    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false, unique = true)
    private OrderEntity order;
}

package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido", nullable = false, length = 150)
    private String orderId;

    @Column(name = "id_producto", nullable = false, length = 150)
    private String idProduct;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private CustomerEntity customer;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private InvoiceEntity invoice;

}

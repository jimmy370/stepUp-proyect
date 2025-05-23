package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedidos")
@Getter
@Setter
public class DetailsOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer amount;

    @Column(name = "precio", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private OrderEntity order;

    // Si tienes entidad Producto, reemplaza este String por una relación
    @Column(name = "codigo_producto", nullable = false, length = 150)
    private String productCode;
}

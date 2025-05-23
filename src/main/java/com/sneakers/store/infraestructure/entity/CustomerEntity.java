package com.sneakers.store.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nombre", nullable = false, length = 100)
    private String name;

    @Column(name ="apellido",nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(name ="telefono",length = 20)
    private String phone;

    @Column(name ="direccion",length = 255)
    private String address;

    @Column(name ="ciudad",length = 100)
    private String city;


    @Column(name ="codigo_postal",length = 20)
    private String postalCode;

    @Column(name ="fecha_nacimiento")
    private LocalDate birthdate;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registrationDate;

    @Column(name = "activo",nullable = false)
    private Boolean active;

    @Column(name = "contraseña")
     private String password;

    @Column(name = "codigo")
     private String codeConfirmation;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderEntity> orders = new ArrayList<>();

}

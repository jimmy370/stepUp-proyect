package com.sneakers.store.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Customer {
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String postalCode;

    private LocalDate birthdate;

    private LocalDateTime RegistrationDate;

    private Boolean active;
}

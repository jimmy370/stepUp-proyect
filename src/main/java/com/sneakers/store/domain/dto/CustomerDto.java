package com.sneakers.store.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class CustomerDto {
    private String name;
    private String email;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private LocalDate birthdate;
    private LocalDateTime registrationDate;
    private String password;
    private String codeConfirmation;
    private List<OrderDto> orders;
}

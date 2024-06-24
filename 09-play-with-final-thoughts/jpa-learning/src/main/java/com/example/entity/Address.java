package com.example.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String doorNumber;
    private String street;
    private String city;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}

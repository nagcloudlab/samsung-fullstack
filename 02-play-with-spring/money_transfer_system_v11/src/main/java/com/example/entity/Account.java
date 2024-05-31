package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "number")
    private String accountNumber;
    private double balance;
    @Column(name = "holder_name")
    private String accountHolderName;

}

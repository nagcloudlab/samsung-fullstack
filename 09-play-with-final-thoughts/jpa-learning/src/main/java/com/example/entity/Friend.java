package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Friend {
    @Id
    private int id;
    private String name;
}

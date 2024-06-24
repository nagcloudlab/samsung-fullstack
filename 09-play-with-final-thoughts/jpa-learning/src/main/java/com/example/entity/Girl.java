package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Girl {
    @Id
    private int id;
    private String name;

    @OneToOne(mappedBy ="girl",targetEntity = Boy.class)
    private Boy boy;

}

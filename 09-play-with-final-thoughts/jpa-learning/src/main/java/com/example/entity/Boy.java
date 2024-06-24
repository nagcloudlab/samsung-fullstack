package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Boy {
    @Id
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "g_id", nullable = false)
    private Girl girl;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "boy_friends",
            joinColumns = {
                    @JoinColumn(name = "b_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "f_id", referencedColumnName = "id")
            }
    )
    private List<Friend> friends = new ArrayList<>();


}

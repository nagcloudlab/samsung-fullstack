package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    @Column(name = "id")
    private int id;

//    @EmbeddedId
//    private EmployeeID employeeID;

    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Lob
    private String profile;
    @Lob
    private byte[] image;

//    @Embedded
//    private Address address;

//    @ElementCollection
//    @CollectionTable(name = "employee_addresses", joinColumns = @JoinColumn(name = "employee_id"))
//    private List<Address> addresses=new ArrayList<>();



}


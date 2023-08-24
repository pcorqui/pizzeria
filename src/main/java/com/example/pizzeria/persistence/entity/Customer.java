package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customer")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "id_customer", nullable = false,unique = true, length = 15)
    private String id_customer;

    @Column(length = 60)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String phone_number;
}

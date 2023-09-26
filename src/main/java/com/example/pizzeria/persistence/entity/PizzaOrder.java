package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Setter
@Getter
@NoArgsConstructor
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer",nullable = false,length = 15)
    private String idCustomer;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @Column(columnDefinition = "Decimal(6,2)", nullable = false)
    private Double total;

    @Column(columnDefinition = "CHAR(1)",nullable = false)
    private String method;

    @Column(length = 200,name = "additional_notes")
    private String additionalNotes;

    @OneToOne
    @JoinColumn(name="id_customer",referencedColumnName = "id_customer",insertable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")//nombre del atributo en orderItem
    private List<OrderItem> itemList;
}

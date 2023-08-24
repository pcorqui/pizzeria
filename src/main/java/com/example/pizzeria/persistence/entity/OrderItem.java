package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderItem {
    @Column(name = "id_item")
    @Id
    private Integer idItem;

    @Column(name = "id_order")
    @Id
    private Integer idOrder;

    @Column(name = "id_pizza")
    private Integer idPizza;

    @Column(columnDefinition = "Decimal(2,1)")
    private Double quantity;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private Double price;

    //con joincolumn definimos el nombre de la columna de la llave foranea
    // si lo omitimos JPA generara el nombre, lo que nos deja a merced del ORM
    // esto puede ser un problema si la tabla ya existe, ya que JPA podria asumir un nombre diferente al que hace referencia
    @ManyToOne
    @JoinColumn(name = "id_order",referencedColumnName = "id_order",insertable = false,updatable = false)
    private PizzaOrder order;

    //id_pizza sera el nombre de la columna en esta tabla
    //hace referencia al atributo de arriba id_pizza
    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false,updatable = false)
    private PizzaEntity pizza;
}

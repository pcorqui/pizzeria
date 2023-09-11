package com.example.pizzeria.web.controller;

import com.example.pizzeria.persistence.entity.PizzaOrder;
import com.example.pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrder>> getAll(){
        return ResponseEntity.ok(this.orderService.getAll());
    }
}

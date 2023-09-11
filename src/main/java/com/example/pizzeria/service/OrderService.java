package com.example.pizzeria.service;

import com.example.pizzeria.persistence.entity.PizzaOrder;
import com.example.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<PizzaOrder> getAll(){
        return this.orderRepository.findAll();
    }
}

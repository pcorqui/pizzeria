package com.example.pizzeria.persistence.repository;

import com.example.pizzeria.persistence.entity.PizzaEntity;
import com.example.pizzeria.persistence.entity.PizzaOrder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<PizzaOrder,Integer> {

}

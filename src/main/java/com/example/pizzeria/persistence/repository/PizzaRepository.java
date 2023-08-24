package com.example.pizzeria.persistence.repository;

import com.example.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

}

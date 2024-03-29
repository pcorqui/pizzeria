package com.example.pizzeria.service;

import com.example.pizzeria.persistence.entity.PizzaEntity;
import com.example.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //no es lo mejor es mejor usar spring repositories
    //pero con JDBC template puedes realizar consultas nativas a sql
    public List<PizzaEntity> getAll(){
        return this.jdbcTemplate.query("SELECT * FROM pizza",new BeanPropertyRowMapper<>(PizzaEntity.class));
    }

    public List<PizzaEntity> getAllRepository(){
        return this.pizzaRepository.findAll();
    }

    public PizzaEntity getById(int id){
        return this.pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
        return pizzaRepository.save(pizza);
    }

    public void delete(int pizza){
        this.pizzaRepository.deleteById(pizza);
    }

    public boolean exist(int id){
        return this.pizzaRepository.existsById(id);
    }
}

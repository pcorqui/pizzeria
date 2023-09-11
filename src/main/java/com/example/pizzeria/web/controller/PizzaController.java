package com.example.pizzeria.web.controller;

import com.example.pizzeria.persistence.entity.PizzaEntity;
import com.example.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("findAll")
    public ResponseEntity<List<PizzaEntity>> getAllRepository(){
        return ResponseEntity.ok(this.pizzaService.getAllRepository());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable int idPizza){
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> getById(@RequestBody PizzaEntity pizza){
        return ResponseEntity.ok(this.pizzaService.save(pizza));
    }

    @PostMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> add(PizzaEntity pizza){
        if(pizza.getIdPizza()== null || !this.pizzaService.exist(pizza.getIdPizza()))
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> update(PizzaEntity pizza){
        if(pizza.getIdPizza()== null || this.pizzaService.exist(pizza.getIdPizza()))
            return ResponseEntity.ok(this.pizzaService.save(pizza));

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza){
        if(this.pizzaService.exist(idPizza)){
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();//devolvemos una respuesta vacia
        }

        return ResponseEntity.badRequest().build();
    }
}

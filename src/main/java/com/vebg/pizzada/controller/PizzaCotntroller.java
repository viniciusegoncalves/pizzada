package com.vebg.pizzada.controller;

import com.vebg.pizzada.entity.Pizza;
import com.vebg.pizzada.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PizzaCotntroller {

    PizzaService service;

    public PizzaCotntroller(PizzaService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<List<Pizza>> create(@Valid @RequestBody Pizza pizza) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(pizza));
    }
    @GetMapping
    public ResponseEntity<List<Pizza>> list(){
        return ResponseEntity.ok(service.list());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pizza>> listByName(@PathVariable String nome){
        return ResponseEntity.ok(service.listByName(nome));
    }
    @PutMapping
    public ResponseEntity<List<Pizza>> update(@RequestBody Pizza pizza) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(pizza));
    }
    @DeleteMapping("/{id}")
    public List<Pizza> delete(@PathVariable Long id){
        return service.delete(id);
    }
}

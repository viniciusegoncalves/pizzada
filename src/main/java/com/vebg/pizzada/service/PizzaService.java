package com.vebg.pizzada.service;

import com.vebg.pizzada.entity.Pizza;
import com.vebg.pizzada.exception.AlreadyExistException;
import com.vebg.pizzada.repository.PizzaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PizzaService {
    PizzaRepository repository;
    RuntimeException responseStatusException =  new ResponseStatusException(HttpStatus.NOT_FOUND);

    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }

    public Pizza create(Pizza pizza) {
        for (Pizza varPizza : list()) {
            if (pizza.getNome().equalsIgnoreCase(varPizza.getNome())) {
                throw new AlreadyExistException("Pizza " + varPizza.getNome()
                        + " já cadastrada!");
            }
        }
        return repository.save(pizza);
    }

    public Optional<Pizza> getById(Long id) {
        return repository.findById(id);
    }

    public List<Pizza> list() {
        return repository.findAll();
    }

    public List<Pizza> listByName(String nome) {
        return repository.findAllByNomeContainingIgnoreCase(nome);
    }

    public List<Pizza> update(Pizza pizza) {
        for (Pizza varPizza : list()) {
            if (Objects.equals(pizza.getId(), varPizza.getId())) {
                repository.save(pizza);
                return list();
            }
        }
        throw responseStatusException;
    }

    public List<Pizza> delete(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw responseStatusException;
        }
        repository.deleteById(id);
        return list();
    }
}
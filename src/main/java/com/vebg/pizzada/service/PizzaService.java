package com.vebg.pizzada.service;

import com.vebg.pizzada.entity.Pizza;
import com.vebg.pizzada.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PizzaService {
    PizzaRepository repository;
    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }
    public List<Pizza> create(Pizza pizza) {
        for(Pizza varPizza : list()) {
            if(pizza.getNome() == varPizza.getNome()) {
                //exception pizza já cadastrada
            }
        }
//        if(pizza.getNome() == null || pizza.getDescricao() == null ||
//        pizza.getPreco() == null) {
//             A pizza precisa conter todos atributos
//        }
        repository.save(pizza);
        return list();
    }
    public List<Pizza> list(){
        return repository.findAll();
    }
    public List<Pizza> listByName(String nome) {
        return repository.findAllByNome(nome);
    }
    public List<Pizza> update(Pizza pizza) {
        for(Pizza varPizza : list()) {
            if (Objects.equals(pizza.getId(), varPizza.getId())) {
                repository.save(pizza);
            }
        }
        //notFoundException
        return list();
    }
    public List<Pizza> delete(Long id){
        if(repository.findById(id).isEmpty()){
            //exception id n encontrado;
        }
        repository.deleteById(id);
        return list();
    }
}

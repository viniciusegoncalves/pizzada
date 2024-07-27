package com.vebg.pizzada.repository;

import com.vebg.pizzada.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    public List<Pizza> findAllByNome(String nome);

}

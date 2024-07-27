package com.vebg.pizzada.repository;

import com.vebg.pizzada.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByNomeContainingIgnoreCase(String nome);

}

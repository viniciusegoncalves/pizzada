package com.vebg.pizzada.repository;

import com.vebg.pizzada.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

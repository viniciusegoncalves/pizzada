package com.vebg.pizzada.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static com.vebg.pizzada.common.PizzaConstants.PIZZA;
import static com.vebg.pizzada.common.PizzaConstants.INVALID_PIZZA;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.vebg.pizzada.entity.Pizza;
import com.vebg.pizzada.repository.PizzaRepository;
import com.vebg.pizzada.service.PizzaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {
    //operacao_estado_retornoesperado
    @InjectMocks
    private PizzaService pizzaService;
    @Mock
    private PizzaRepository pizzaRepository;

    @Test
    public void createPizza_WithValidData_ReturnsPizza() {
        //AAA
        //Arrange
        when(pizzaRepository.save(PIZZA)).thenReturn(PIZZA);
        //Act
        Pizza sut = pizzaService.create(PIZZA); //system under test
        //Assert
        assertThat(sut).isEqualTo(PIZZA);
    }

    @Test
    public void createPizza_WithInvalidData_ThrowsException() {
        when(pizzaRepository.save(INVALID_PIZZA)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> pizzaService.create(INVALID_PIZZA))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPizza_ByExistingId_ReturnPizza() {
        when(pizzaRepository.findById(anyLong())).thenReturn(Optional.of(PIZZA));

        Optional<Pizza> sut = pizzaService.getById(1L);

        assertThat(sut.isPresent());
        assertThat(sut.get()).isEqualTo(PIZZA);
    }

    @Test
    public void getPizza_ByUnexistingId_ReturnPizza() {
        when(pizzaRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Pizza> sut = pizzaService.getById(1L);

        assertThat(sut).isEmpty();
    }

    @Test
    public void getPizza_ByExistingName_ReturnPizza() {
    }

    @Test
    public void getPizza_ByUnexistingName_ReturnPizza() {
    }




}

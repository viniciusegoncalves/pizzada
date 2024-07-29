package com.vebg.pizzada.common;

import com.vebg.pizzada.entity.Pizza;

public class PizzaConstants {
    public static final Pizza PIZZA = new Pizza("Nome", "Descricao", 100.0);
    public static final Pizza INVALID_PIZZA = new Pizza("", "",0.0);


}

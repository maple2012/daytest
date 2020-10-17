package com.java8.stream.Test.demo;

import com.java8.stream.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork",false,800,Dish.Type.MEAT),
            new Dish("beef",false,700,Dish.Type.MEAT),
            new Dish("salmon",false,450,Dish.Type.FISH),
            new Dish("rice",true,950,Dish.Type.OTHER)
        );
//        System.out.println(menu.stream().dropWhile(dish -> dish.getCalories() < 400).collect(Collectors.toList()));
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish);
    }
}

package com.java8.stream.Test.demo;

import com.java8.stream.entity.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Test
    public void flatMap(){
        String[] arrayOfWords = {"hello","word"};
        Arrays.stream(arrayOfWords).map(word->word.split("")).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(Arrays.stream(arrayOfWords).map(word->word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
        Integer[] baseNum = {1,2,3,4,5};
        System.out.println(Arrays.stream(baseNum).map(num->num*num).collect(Collectors.toList()));
        Integer[] a = {1,2,3};
        Integer[] b = {3,4};
        List<int[]> numArray = Arrays.stream(a).flatMap(i-> Arrays.stream(b).map(j->new int[]{i,j})).collect(Collectors.toList());
        return;
    }
}

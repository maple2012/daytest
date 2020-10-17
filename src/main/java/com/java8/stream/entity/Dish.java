package com.java8.stream.entity;

public class Dish {
    private final String name;
    /**
     * 是否为素菜
     */
    private final boolean vegetarian;
    /**
     * 卡路里
     */
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
    public enum Type{MEAT,FISH,OTHER}
}

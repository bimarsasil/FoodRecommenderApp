package com.example.ifoodrecommender.data.model;

public class FoodRecipeContent {
    //  set data for food recipe

    private String name;
    private FoodCategory type;
    private double numMeasure;
    private double calories;
    private double fat;
    private double cholesterol;
    private double sodium;
    private double carbohydrate;
    private double protein;
    private double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodCategory getType() {
        return type;
    }

    public void setType(FoodCategory type) {
        this.type = type;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getNumMeasure() {
        return numMeasure;
    }

    public void setNumMeasure(double numMeasure) {
        this.numMeasure = numMeasure;
    }
}

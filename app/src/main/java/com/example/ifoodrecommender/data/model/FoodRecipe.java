package com.example.ifoodrecommender.data.model;

import java.util.ArrayList;

public class FoodRecipe {

    public static double CalculateRecipeValues(FoodRecipe _recipe, LoggedInUser _user) {

        return 1.0;
    }
    private ArrayList<FoodRecipeContent> content;
    private double calories;
    private double fat;
    private double cholesterol;
    private double sodium;
    private double carbohydrate;
    private double protein;
    private double cost;
    private int order;
    public static double CalculateRecipeValues(FoodRecipe o1) {
        return 0.0;
    }

    public ArrayList<FoodRecipeContent> getContent() {
        return content;
    }

    public void setContent(ArrayList<FoodRecipeContent> content) {
        this.content = content;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

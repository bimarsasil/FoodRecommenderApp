package com.example.ifoodrecommender.data.model;

import com.example.ifoodrecommender.R;

import java.util.ArrayList;

public class Recipe {

    private String _name;
    private double _cost, _calories, _fat, _cholesterol;
    private int _imgId;
    // default constructor
    public Recipe() { }
    public Recipe(String name, double cost, double calories, double fat, double cholesterol, int imgId) {
        this.set_cost(cost);
        this.set_name(name);
        this.set_calories(calories);
        this.set_fat(fat);
        this.set_cholesterol(cholesterol);
        this.set_imgId(imgId);
    }

        // getters and setters
    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }
    public double get_cost() {
        return _cost;
    }
    public void set_cost(double _cost) {
        this._cost = _cost;
    }
    public double get_calories() {
        return _calories;
    }
    public void set_calories(double _calories) {
        this._calories = _calories;
    }
    public double get_fat() {
        return _fat;
    }
    public void set_fat(double _fat) {
        this._fat = _fat;
    }
    public double get_cholesterol() {
        return _cholesterol;
    }
    public void set_cholesterol(double _cholesterol) {
        this._cholesterol = _cholesterol;
    }
    public int get_imgId() {
        return _imgId;
    }
    public void set_imgId(int _imgId) {
        this._imgId = _imgId;
    }


    // set list values
    public static ArrayList<Recipe> GenerateRecipeList() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("My Recipe (1)", 14.90, 340,112,520, R.drawable.img2));
        recipeList.add(new Recipe("Recipe 2", 20.25, 360.25,190.5,360,R.drawable.img3 ));
        recipeList.add(new Recipe("Recipe 3", 30.65, 410.2,144.7,190,R.drawable.img1 ));
        return recipeList;
    }
}

package com.example.ifoodrecommender.data.model;

public class FoodCategory {
    private String _name;
    private int _measure;
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }
    public int getMeasure() {
        return _measure;
    }
    public void setMeasure(int measure) {
        this._measure = measure;
    }
}

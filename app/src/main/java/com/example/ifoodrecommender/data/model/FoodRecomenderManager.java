package com.example.ifoodrecommender.data.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Comparator;
import java.util.List;

public class FoodRecomenderManager {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<FoodRecipe> OrderRecipes(List<FoodRecipe> _input) {
        _input.sort(new Comparator<FoodRecipe>() {
            @Override
            public int compare(FoodRecipe o1, FoodRecipe o2) {
                return Double.compare(FoodRecipe.CalculateRecipeValues(o1),FoodRecipe.CalculateRecipeValues(o1));
            }
        });
        return _input;
    }
}

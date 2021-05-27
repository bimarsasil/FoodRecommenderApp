package com.example.ifoodrecommender.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ifoodrecommender.R;
import com.example.ifoodrecommender.data.model.LoggedInUser;
import com.example.ifoodrecommender.data.model.Recipe;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRecipeDataAdapter extends RecyclerView.Adapter<FoodRecipeDataAdapter.ViewHolder>  {

    private List<Recipe> recipes;
    private Context context;
    public FoodRecipeDataAdapter(List<Recipe> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(context).inflate(R.layout.recipe_contact, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }
    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        final Recipe recipe = recipes.get(position);
        ImageView imgView = holder.imgView;
        TextView costTextView = holder._costTextView;
        TextView caloriesTextView = holder._caloriesTextView;
        TextView fatTextView = holder._fatTextView;
        TextView cholesterolTextView = holder._cholesterolTextView;
        TextView awarenessTextView = holder._awarenessTextView;
        Button selectRecipe = holder._userSelectRecipe;
        //TextView cholesterolTextView = holder.aw;

        // Set item views based on your views and data model
        costTextView.setText("$" + String.format("%.2f", recipe.get_cost()));
        caloriesTextView.setText(String.format("%.2f", recipe.get_calories()));
        fatTextView.setText(String.format("%.2f", recipe.get_fat()));
        cholesterolTextView.setText(String.format("%.2f", recipe.get_cholesterol()));
        int resourceId = recipe.get_imgId(); // context.getResources().getIdentifier(recipe.getImgName(), "drawable", context.getPackageName());
        imgView.setImageDrawable(context.getResources().getDrawable(resourceId));
        final String awareness = String.format("%.2f", recipe.get_cost() / (recipe.get_fat() + recipe.get_calories() + recipe.get_cholesterol()));
        awarenessTextView.setText(awareness);
        final LoggedInUser user= LoginFBDSource.getLoggedInUser();
        selectRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> recipeSelected = new HashMap<>();
                recipeSelected.put("user", user.get_uname());
                recipeSelected.put("recipe", recipe.get_name());
                recipeSelected.put("awareness", awareness);
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                // add to collection
                db.collection("recipeSelectioon")
                        .add(recipeSelected)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
        });
        //costTextView.setText(String.format("%.2f", recipe.getCost()));
    }
    @Override
    public int getItemCount() {
        return recipes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private String name;
        public ImageView imgView;
        public TextView _costTextView, _caloriesTextView, _fatTextView, _cholesterolTextView, _awarenessTextView;
        public Button _userSelectRecipe;
        public Button _messageButton;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            imgView = itemView.findViewById(R.id.img);
            _costTextView = itemView.findViewById(R.id.cost);
            _caloriesTextView = itemView.findViewById(R.id.calories);
            _fatTextView = itemView.findViewById(R.id.fat);
            _cholesterolTextView = itemView.findViewById(R.id.cholesterol);
            _awarenessTextView = itemView.findViewById(R.id.awarnress);
            _userSelectRecipe = itemView.findViewById(R.id.slectReceipe);
        }
    }
}

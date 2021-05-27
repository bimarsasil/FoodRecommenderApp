package com.example.ifoodrecommender;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.ifoodrecommender.data.LoginFBDSource;
import com.example.ifoodrecommender.data.model.LoggedInUser;

public class AddRecipeFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false);
    }

    @SuppressLint("DefaultLocale")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get Text UIs
        TextView BMI= view.findViewById(R.id.BMI);
        TextView BodyFat= view.findViewById(R.id.BodyFat);
        TextView WH= view.findViewById(R.id.WH);

        /* get the current user */
        LoggedInUser user= LoginFBDSource.getLoggedInUser();

        /* calculate health indicators */
        user.CalculateHelthIndicators();
        BMI.setText(String.format("%.2f", user.getBMI()));
        BodyFat.setText(String.format("%.2f", user.getBodyFat()));
        WH.setText(String.format("%.2f", user.getWH()));

        view.findViewById(R.id.showReciepes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddRecipeFragment.this)
                        .navigate(R.id.action_First2Fragment_to_Second2Fragment);
            }
        });
    }
}

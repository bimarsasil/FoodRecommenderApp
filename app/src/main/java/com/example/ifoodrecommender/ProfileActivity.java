package com.example.ifoodrecommender;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ifoodrecommender.data.LoginFBDSource;
import com.example.ifoodrecommender.data.model.LoggedInUser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button createProfile = findViewById(R.id.showAllReciepes);
        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedInUser user= LoginFBDSource.getLoggedInUser();
                EditText height = findViewById(R.id.height);
                EditText weight = findViewById(R.id.weight);
                EditText waist = findViewById(R.id.waist);
                EditText age = findViewById(R.id.age);
                RadioGroup radioGroupId = findViewById(R.id.genderGroup);
                int selectedOption = radioGroupId.getCheckedRadioButtonId();
                // find the radiobutton by the previously returned id
                RadioButton radioGenderButton = findViewById(selectedOption);
                try {
                    user.set_weight(Integer.parseInt(weight.getText().toString()));
                    user.set_height(Integer.parseInt(height.getText().toString()));
                    user.set_age(Integer.parseInt(age.getText().toString()));
                    user.set_waist(Integer.parseInt(waist.getText().toString()));
                    user.set_gender(radioGenderButton.getText().toString());
                    Toast.makeText(getApplicationContext(), "User Profile Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
                    startActivity(intent);

                }
                catch(Exception ex) {
                    Toast.makeText(getApplicationContext(), "Error in Profile Update", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

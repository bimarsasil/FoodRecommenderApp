package com.example.ifoodrecommender.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ifoodrecommender.ProfileActivity;
import com.example.ifoodrecommender.R;
import com.example.ifoodrecommender.data.LoginFBDSource;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private LoginFBDSource loginFBDSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        // String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        loginFBDSource =new LoginFBDSource();
        loginFBDSource.register();
//        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
//        startActivity(intent);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginFBDSource.login(usernameEditText.getText().toString(), passwordEditText.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                }
                else {

                }
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}

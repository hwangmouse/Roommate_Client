package com.example.roommateplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        Button buttonLogin = findViewById(R.id.button_login);
        Button buttonSignup = findViewById(R.id.button_signup);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // LoginScreen으로 이동
                Intent intent = new Intent(HomeScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // LoginScreen으로 이동
                Intent intent = new Intent(HomeScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}

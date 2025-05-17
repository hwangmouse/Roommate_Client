package com.example.roommateplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.CheckList.CL1;

public class RecommendScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendscreen);

        Button btnTabMyPage = findViewById(R.id.btnTabMyPage);
        Button btnTabInspect = findViewById(R.id.btnTabInspect);

        btnTabMyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(RecommendScreen.this, MyPageScreen.class);
                startActivity(intent);
            }
        });

        btnTabInspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(RecommendScreen.this, CL1.class);
                startActivity(intent);
            }
        });
    }
}

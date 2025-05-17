package com.example.roommateplatform;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.CheckList.CL1;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingscreen);

        // 2초 후 HomeScreen(MainActivity)으로 이동
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingScreen.this, HomeScreen.class);
                startActivity(intent);
                finish(); // 뒤로가기 눌렀을 때 다시 로딩화면으로 안 돌아가게
            }
        }, 2000); // 2000ms = 2초
    }
}

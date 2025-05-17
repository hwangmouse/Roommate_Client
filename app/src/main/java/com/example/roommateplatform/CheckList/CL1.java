package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.HomeScreen;
import com.example.roommateplatform.LoginScreen;
import com.example.roommateplatform.R;

public class CL1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist1);

        Button buttonoption1 = findViewById(R.id.btnOption1);

        buttonoption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다음 체크리스트로 이동

                Intent intent = new Intent(CL1.this, CL2.class);
                intent
                startActivity(intent);
            }
        });

        Button buttonoption2 = findViewById(R.id.btnOption2);

        buttonoption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다음 체크리스트로 이동
                Intent intent = new Intent(CL1.this, CL2.class);
                startActivity(intent);
            }
        });

        Button buttonoption3 = findViewById(R.id.btnOption3);

        buttonoption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다음 체크리스트로 이동
                Intent intent = new Intent(CL1.this, CL2.class);
                startActivity(intent);
            }
        });



        Button buttonMypage = findViewById(R.id.btnTabMyPage);

        buttonMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mypage로 이동
                //Intent intent = new Intent(CL1.this, Mypage.class);
                //startActivity(intent);
            }
        });

        Button buttoninspect = findViewById(R.id.btnTabInspect);

        buttoninspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inspect  이동
                //Intent intent = new Intent(CL1.this, Inspect.class);
                //startActivity(intent);
            }
        });

        Button buttonrecommend = findViewById(R.id.btnTabRecommend);

        buttonrecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // recommend 이동
                //Intent intent = new Intent(CL1.this, recommend.class);
                //startActivity(intent);
            }
        });

    }
}

package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL9 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_9_ANSWER = "QUESTION_9_ANSWER";

    Button btnOption1, btnOption2, btnOption3;
    private String question8Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist9);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("많이 탐"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("중간"); // 선택된 값
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("적게 함"); // 선택된 값
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
    private void navigateToNextActivity(String question9Answer) {
        Intent checklistIntent = new Intent(CL9.this, CL10.class);
        // Intent에 데이터 추가
        checklistIntent.putExtra(CL8.EXTRA_QUESTION_8_ANSWER, question8Answer);
        checklistIntent.putExtra(EXTRA_QUESTION_9_ANSWER, question9Answer);
        startActivity(checklistIntent);
    }
}

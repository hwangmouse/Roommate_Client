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
    public static final String EXTRA_QUESTION_1_ANSWER = "QUESTION_1_ANSWER";

    Button btnOption1, btnOption2, btnOption3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist1);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("Q1_오전6시_9시"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("Q1_오전9시_12시"); // 선택된 값
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("Q1_그이후"); // 선택된 값
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
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE";
    private void navigateToNextActivity(String question1Answer) {
        Intent checklistIntent = new Intent(CL1.this, CL2.class);
        Bundle bundle = new Bundle();
        bundle.putString(CL1.EXTRA_QUESTION_1_ANSWER, question1Answer);
        // Intent에 데이터 추가
        checklistIntent.putExtra(BUNDLE_ANSWERS, bundle);
        startActivity(checklistIntent);
    }
}

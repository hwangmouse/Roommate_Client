package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL6 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_6_ANSWER = "homeReturnCycle";

    private Bundle receivedBundle;
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE";
    Button btnOption1, btnOption2, btnOption3, btnOption4;

    private String question5Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist6);

        Intent intent = getIntent();
        receivedBundle = intent.getBundleExtra(BUNDLE_ANSWERS); // Bundle을 통째로 가져옴

        if (receivedBundle == null) { // 혹시 Bundle이 없는 경우를 대비해 새로 생성
            receivedBundle = new Bundle();
        }

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("매주"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("2주"); // 선택된 값
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("한달 이상"); // 선택된 값
            }
        });

        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("거의 안감"); // 선택된 값
            }
        });
    }
    private void navigateToNextActivity(String question6Answer) {
        Intent checklistIntent = new Intent(CL6.this, CL7.class);
        // Intent에 데이터 추가
        receivedBundle.putString(EXTRA_QUESTION_6_ANSWER, question6Answer);

        checklistIntent.putExtra(BUNDLE_ANSWERS, receivedBundle);
        startActivity(checklistIntent);
    }
}

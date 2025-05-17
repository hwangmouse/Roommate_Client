package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL4 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_4_ANSWER = "QUESTION_4_ANSWER";
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE"; // CL1과 동일한 키 사용
    private Bundle receivedBundle;
    Button btnOption1, btnOption2, btnOption3;
    private String question3Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist4);

        Intent intent = getIntent();
        receivedBundle = intent.getBundleExtra(BUNDLE_ANSWERS); // Bundle을 통째로 가져옴

        if (receivedBundle == null) { // 혹시 Bundle이 없는 경우를 대비해 새로 생성
            receivedBundle = new Bundle();
        }

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("심함"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
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
                navigateToNextActivity("약함"); // 선택된 값
            }
        });
    }
    private void navigateToNextActivity(String question4Answer) {
        Intent checklistIntent = new Intent(CL4.this, CL5.class);
        // Intent에 데이터 추가
        receivedBundle.putString(EXTRA_QUESTION_4_ANSWER, question4Answer);

        checklistIntent.putExtra(BUNDLE_ANSWERS, receivedBundle); // 수정된 Bundle을 다음 액티비티로 전달
        startActivity(checklistIntent);
    }
}

package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL7 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_7_ANSWER = "QUESTION_7_ANSWER";

    private Bundle receivedBundle;
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE";

    Button btnOption1, btnOption2;
    private String question6Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist7);

        Intent intent = getIntent();
        receivedBundle = intent.getBundleExtra(BUNDLE_ANSWERS); // Bundle을 통째로 가져옴

        if (receivedBundle == null) { // 혹시 Bundle이 없는 경우를 대비해 새로 생성
            receivedBundle = new Bundle();
        }

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("o"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("x"); // 선택된 값
            }
        });
    }
    private void navigateToNextActivity(String question7Answer) {
        Intent checklistIntent = new Intent(CL7.this, CL8.class);
        // Intent에 데이터 추가
        receivedBundle.putString(EXTRA_QUESTION_7_ANSWER, question7Answer);

        checklistIntent.putExtra(BUNDLE_ANSWERS, receivedBundle);
        startActivity(checklistIntent);
    }
}

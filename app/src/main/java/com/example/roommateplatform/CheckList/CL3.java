package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL3 extends AppCompatActivity {
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE";
    public static final String EXTRA_QUESTION_3_ANSWER = "QUESTION_3_ANSWER";

    Button btnOption1, btnOption2;

    private Bundle receivedBundle;
    private String question2Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist3);

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
                navigateToNextActivity("밝음"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("어두움"); // 선택된 값
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
    private void navigateToNextActivity(String question3Answer) {
        Intent checklistIntent = new Intent(CL3.this, CL4.class);
        // Intent에 데이터 추가
        receivedBundle.putString(EXTRA_QUESTION_3_ANSWER, question3Answer);

        checklistIntent.putExtra(BUNDLE_ANSWERS, receivedBundle); // 수정된 Bundle을 다음 액티비티로 전달
        startActivity(checklistIntent);
    }
}

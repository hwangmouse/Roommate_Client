package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;

public class CL3 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_3_ANSWER = "QUESTION_3_ANSWER";

    Button btnOption1, btnOption2;

    private String question2Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist3);

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
    }
    private void navigateToNextActivity(String question3Answer) {
        Intent checklistIntent = new Intent(CL3.this, CL4.class);
        // Intent에 데이터 추가
        checklistIntent.putExtra(CL2.EXTRA_QUESTION_2_ANSWER, question2Answer);
        checklistIntent.putExtra(EXTRA_QUESTION_3_ANSWER, question3Answer);
        startActivity(checklistIntent);
    }
}

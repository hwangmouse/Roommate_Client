package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;
import com.example.roommateplatform.RecommendScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CL10 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_10_ANSWER = "studyPlace";

    Button btnOption1, btnOption2, btnOption3;
    private String question9Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist10);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);


        // 중앙 버튼 클릭 리스너 설정
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("안"); // 선택된 값 (예: "1" 대신 의미있는 문자열)
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("밖"); // 선택된 값
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("유동적"); // 선택된 값
            }
        });
    }
    private void navigateToNextActivity(String question10Answer) {
        Intent checklistIntent = new Intent(CL10.this, RecommendScreen.class);
        // Intent에 데이터 추가
        checklistIntent.putExtra(CL9.EXTRA_QUESTION_9_ANSWER, question9Answer);
        checklistIntent.putExtra(EXTRA_QUESTION_10_ANSWER, question10Answer);
        startActivity(checklistIntent);
    }
}

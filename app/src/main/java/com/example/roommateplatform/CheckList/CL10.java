package com.example.roommateplatform.CheckList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.R;
import com.example.roommateplatform.RecommendScreen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.http.Body;
//import retrofit2.http.POST;

public class CL10 extends AppCompatActivity {
    public static final String EXTRA_QUESTION_10_ANSWER = "QUESTION_10_ANSWER";
    // Bundle 자체를 식별하는 키 (모든 CL 액티비티에서 동일해야 함)
    public static final String BUNDLE_ANSWERS = "ANSWERS_BUNDLE"; // 이 키는 CL1~CL9에서도 동일하게 사용되어야 합니다.

    Button btnOption1, btnOption2, btnOption3;

    // 이전 액티비티들로부터 전달받은 모든 답변을 저장할 변수
    private String q1Answer, q2Answer, q3Answer, q4Answer, q5Answer,
            q6Answer, q7Answer, q8Answer, q9Answer;

//    public interface ApiService {
//        @POST("your/server/endpoint")
//        Call<Void> submitChecklist(@Body RequestBody checklistData);
//    }

    //private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist10);

        // --- Retrofit 설정 (기존 코드 유지) ---
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://YOUR_SERVER_IP_OR_DOMAIN:PORT/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        apiService = retrofit.create(ApiService.class);
        // --- Retrofit 설정 끝 ---

        // --- Intent로부터 Bundle 받아오기 및 데이터 추출 ---
        Intent intent = getIntent();
        Bundle allAnswersBundle = intent.getBundleExtra(BUNDLE_ANSWERS); // Bundle 키로 Bundle 객체 가져오기

        if (allAnswersBundle != null) {
            // Bundle에서 각 질문의 답변 추출
            // 각 CLX.EXTRA_QUESTION_X_ANSWER는 해당 CLX.java 파일에 정의된 상수여야 합니다.
            q1Answer = allAnswersBundle.getString(CL1.EXTRA_QUESTION_1_ANSWER);
            q2Answer = allAnswersBundle.getString(CL2.EXTRA_QUESTION_2_ANSWER); // CL2.java에 정의된 상수
            // CL3부터 CL9까지의 상수를 정확히 참조해야 합니다.
            // 예시: com.example.roommateplatform.CheckList.CL3.EXTRA_QUESTION_3_ANSWER
            // 실제 프로젝트 구조에 맞게 패키지명을 포함하거나, Constants 클래스를 만들어 관리하는 것이 좋습니다.
            q3Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL3.EXTRA_QUESTION_3_ANSWER);
            q4Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL4.EXTRA_QUESTION_4_ANSWER);
            q5Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL5.EXTRA_QUESTION_5_ANSWER);
            q6Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL6.EXTRA_QUESTION_6_ANSWER);
            q7Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL7.EXTRA_QUESTION_7_ANSWER);
            q8Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL8.EXTRA_QUESTION_8_ANSWER);
            q9Answer = allAnswersBundle.getString(com.example.roommateplatform.CheckList.CL9.EXTRA_QUESTION_9_ANSWER);

            // (디버깅용) Toast로 모든 값 확인
            StringBuilder toastMessage = new StringBuilder("Bundle로 받은 답변들:\n");
            toastMessage.append("Q3: ").append(q3Answer != null ? q3Answer : "N/A").append("\n");
            toastMessage.append("Q4: ").append(q4Answer != null ? q4Answer : "N/A").append("\n");
            toastMessage.append("Q5: ").append(q5Answer != null ? q5Answer : "N/A").append("\n");
            toastMessage.append("Q6: ").append(q6Answer != null ? q6Answer : "N/A").append("\n");
            toastMessage.append("Q7: ").append(q7Answer != null ? q7Answer : "N/A").append("\n");
            toastMessage.append("Q8: ").append(q8Answer != null ? q8Answer : "N/A").append("\n");
            toastMessage.append("Q9: ").append(q9Answer != null ? q9Answer : "N/A");
            Toast.makeText(this, toastMessage.toString(), Toast.LENGTH_LONG).show();
            Log.d("CL10_BUNDLE_VALUES", toastMessage.toString()); // 로그로도 확인

        } else {
            Toast.makeText(this, "답변 Bundle을 받지 못했습니다. 이전 단계 확인 필요.", Toast.LENGTH_LONG).show();
            Log.e("CL10_BUNDLE_ERROR", "allAnswersBundle is null. Check previous activities.");
            // Bundle이 null일 경우, 이전 액티비티에서 Bundle을 제대로 전달하지 않았을 가능성이 높습니다.
            // 이 경우 q1Answer ~ q9Answer는 null 상태이므로, JSON 생성 시 NullPointerException이 발생할 수 있습니다.
            // 적절한 기본값을 설정하거나, 오류 처리를 해야 합니다.
            // 예: q1Answer = "기본값1"; 또는 서버 전송 로직을 실행하지 않도록 처리
        }
        // --- Bundle 처리 끝 ---


        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextActivity("많이 함"); // 선택된 값
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

        // ... (기존의 Mypage, Inspect, Recommend 탭 버튼 리스너) ...
    }

    private void handleSelectionAndSendData(String question10Answer) {
        JSONObject checklistJson = new JSONObject();
        try {
            // Bundle에서 가져온 값들을 JSON에 넣기
            // 값이 null일 경우를 대비하여 기본값 또는 빈 문자열 처리 등을 고려할 수 있습니다.
            checklistJson.put("q1_sleep_pattern", q1Answer != null ? q1Answer : "");
            checklistJson.put("q2_cleanliness", q2Answer != null ? q2Answer : "");
            checklistJson.put("q3_study_habits", q3Answer != null ? q3Answer : "");
            checklistJson.put("q4_social_life", q4Answer != null ? q4Answer : "");
            checklistJson.put("q5_noise_level", q5Answer != null ? q5Answer : "");
            checklistJson.put("q6_guests_policy", q6Answer != null ? q6Answer : "");
            checklistJson.put("q7_sharing_items", q7Answer != null ? q7Answer : "");
            checklistJson.put("q8_temperature_pref", q8Answer != null ? q8Answer : "");
            checklistJson.put("q9_pets_allowed", q9Answer != null ? q9Answer : "");
            checklistJson.put("q10_drinking_smoking", question10Answer);

        } catch (JSONException e) {
            Log.e("CL10_JSON_ERROR", "JSON 객체 생성 중 오류 발생", e);
            Toast.makeText(this, "데이터 준비 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            navigateToNextActivity(question10Answer); // 오류 시에도 이동 (정책에 따라 변경)
            return;
        }

      //  sendChecklistDataToServer(checklistJson.toString(), question10Answer);
    }

//    private void sendChecklistDataToServer(String jsonBodyString, String question10AnswerForIntent) {
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBodyString);
//        Log.d("CL10_SEND_JSON", "서버로 전송할 JSON: " + jsonBodyString);
//
//        apiService.submitChecklist(requestBody).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(CL10.this, "체크리스트가 성공적으로 제출되었습니다!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(CL10.this, "체크리스트 제출 실패. 서버 오류: " + response.code(), Toast.LENGTH_LONG).show();
//                    try {
//                        Log.e("CL10_SERVER_ERROR", "Server error: " + response.code() + " - " + (response.errorBody() != null ? response.errorBody().string() : "No error body"));
//                    } catch (IOException e) {
//                        Log.e("CL10_SERVER_ERROR", "Error reading error body", e);
//                    }
//                }
//                navigateToRecommendScreen(question10AnswerForIntent);
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(CL10.this, "네트워크 오류: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                Log.e("CL10_NETWORK_ERROR", "Network failure", t);
//                navigateToRecommendScreen(question10AnswerForIntent);
//            }
//        });
//    }

    private void navigateToNextActivity(String question10Answer) {
        Intent recommendIntent = new Intent(CL10.this, RecommendScreen.class);
        recommendIntent.putExtra(EXTRA_QUESTION_10_ANSWER, question10Answer);
        startActivity(recommendIntent);
        finish();
    }
}
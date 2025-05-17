package com.example.roommateplatform;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignupScreen extends AppCompatActivity {

    EditText nameInput, emailInput, ageInput, passwordInput, confirmPasswordInput, kakaoLinkInput;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupscreen);

        nameInput = findViewById(R.id.nameInput);           // xml에 id 부여 필요
        emailInput = findViewById(R.id.emailInput);
        ageInput = findViewById(R.id.ageInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        kakaoLinkInput = findViewById(R.id.kakaoLinkInput);
        genderGroup = findViewById(R.id.genderGroup);

        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(v -> sendToServer());
    }

    private void sendToServer() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String age = ageInput.getText().toString();
        String password = passwordInput.getText().toString();
        String kakaoLink = kakaoLinkInput.getText().toString();

        // 선택된 성별 확인
        int genderId = genderGroup.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(genderId);
        String gender = selectedGender != null ? selectedGender.getText().toString() : "";

        // JSON 객체 만들기
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", name);
            jsonObject.put("email", email);
            jsonObject.put("age", age);
            jsonObject.put("password", password);
            jsonObject.put("gender", gender);
            jsonObject.put("kakaoLink", kakaoLink);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        // OkHttp로 POST 요청 보내기
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                jsonObject.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url("http://YOUR_SERVER_IP:PORT/signup")  // Spring Boot 서버 주소로 바꿔줘
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("Signup", "서버 응답: " + response.body().string());
            }
        });
    }
}

package com.example.roommateplatform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginScreen extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private AppCompatButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            try {
                JSONObject json = new JSONObject();
                json.put("email", email);
                json.put("password", password);

                OkHttpClient client = new OkHttpClient();

                RequestBody body = RequestBody.create(
                        json.toString(),
                        MediaType.get("application/json; charset=utf-8")
                );

                Request request = new Request.Builder()
                        .url("http://10.0.2.2:8080/api/auth/login")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(() -> {
                            Toast.makeText(LoginScreen.this, "서버 연결 실패", Toast.LENGTH_SHORT).show();
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            runOnUiThread(() -> {
                                Intent intent = new Intent(LoginScreen.this, MyPageScreen.class);
                                startActivity(intent);
                                finish();
                            });
                        } else {
                            runOnUiThread(() -> {
                                Toast.makeText(LoginScreen.this, "로그인 실패: 계정 정보를 확인하세요", Toast.LENGTH_SHORT).show();
                            });
                        }
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(LoginScreen.this, "입력값 오류", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

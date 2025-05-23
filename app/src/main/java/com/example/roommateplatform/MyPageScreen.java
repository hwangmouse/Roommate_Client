package com.example.roommateplatform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roommateplatform.CheckList.CL1;

public class MyPageScreen extends AppCompatActivity {
    private static final int REQUEST_IMAGE_PICK = 1001;
    private ImageView imageProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypagescreen);

        imageProfile = findViewById(R.id.imageProfile);

        imageProfile.setOnClickListener(v -> {
            // 갤러리 열기
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_IMAGE_PICK);
        });

        Button btnTabRecommend = findViewById(R.id.btnTabRecommend);
        Button btnTabInspect = findViewById(R.id.btnTabInspect);

        btnTabRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(MyPageScreen.this, RecommendScreen.class);
                startActivity(intent);
            }
        });

        btnTabInspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(MyPageScreen.this, CL1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            imageProfile.setImageURI(selectedImageUri);
        }
    }
}

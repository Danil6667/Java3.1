package com.example.java31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_PHOTO = 3;
    //константа называется финал

    private ImageView imageView;
    private MaterialCardView whatsappContainer, youtubeContainer;
    private EditText etInput;
    private MaterialButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        whatsappContainer = findViewById(R.id.whatsapp_container);
        youtubeContainer = findViewById(R.id.google_container);
        etInput = findViewById(R.id.et_input);
        btnSend = findViewById(R.id.btn_send);
        setUpListener();
    }

    private void setUpListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // мы собираемся передать текст 2му активити
                String text = etInput.getText().toString().trim();
                if (text.isEmpty()) {
                    etInput.setError("поле должно быть заполненным");
                } else {
                    // тут уже явный интент(намериние)
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //тут мы даем ключ к другому активити
                    intent.putExtra("text", text);
                    // он запускает 2й активити
                    startActivity(intent);
                }
                //что такое явный итент то это должно реально
            }
            // что такое Трим trim(); оно убирает пробелы, что такое replace(); замена текста
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Photo"), PICK_PHOTO);
            }
        });

        youtubeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/search?q=" + text));
                startActivity(intent);
            }
        });
        whatsappContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://wa.me/"+text));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO && requestCode == Activity.RESULT_OK){
            if (data != null){
                imageView.setImageURI(data.getData());
            }
        }
    }




}
// что такое интент это переход,
// что такое интент это намериние
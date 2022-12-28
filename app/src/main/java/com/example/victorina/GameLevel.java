package com.example.victorina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        Window bar = getWindow();
        bar.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevel.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
    }

    //работа системной конпоки назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevel.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }
    //конец работы над системной кнопкой назад
}
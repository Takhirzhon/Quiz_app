package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.button);


        start.setOnClickListener((v) -> {
                try {
                    Intent intent = new Intent(MainActivity.this, GameLevel.class);
                    startActivity(intent); finish();
                } catch (Exception e) {

                }
        });

        Window bar = getWindow();
        bar.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }




    public void checkAnswer(View view) {
        ImageView imageView = (ImageView) view;
        int id = imageView.getId();

        if (id == R.id.img_left1) {
            Toast.makeText(this, "Right answer!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }
    }


    //системная кнопка для выхода
    @Override
    public void onBackPressed(){
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти.", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
    //системная кнопка для выхода(конец кода)

}
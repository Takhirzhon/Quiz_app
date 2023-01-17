package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //код который скругляет углы ImageView for questions  - НАЧАЛО
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_left1 = (ImageView)findViewById(R.id.img_left1);
        img_left1.setClipToOutline(true);

        final ImageView img_bottom = (ImageView)findViewById(R.id.img_bottom);
        img_bottom.setClipToOutline(true);

        final ImageView img_bottom1 = (ImageView)findViewById(R.id.img_bottom1);
        img_bottom1.setClipToOutline(true);
        //код который скругляет углы ImageView for questions  - КОНЕЦ


        //развертывание игры на весь экарн
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // конец развертывания
    }
}
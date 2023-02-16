package com.example.victorina;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Level1 extends AppCompatActivity {

    public int num1 = 0;
    public int num2 = 1;
    public int num3 = 2;
    public int num4 = 3;
    public Array array = new Array();
    public int count = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Создал переменную text_level
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1); //Установил текст

        //код который скругляет углы ImageView for questions  - НАЧАЛО
        final ImageView img_left = findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_left1 = findViewById(R.id.img_left1);
        img_left1.setClipToOutline(true);

        final ImageView img_bottom = findViewById(R.id.img_bottom);
        img_bottom.setClipToOutline(true);

        final ImageView img_bottom1 = findViewById(R.id.img_bottom1);
        img_bottom1.setClipToOutline(true);
        //код который скругляет углы ImageView for questions  - КОНЕЦ


        //развертывание игры на весь экарн
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // конец развертывания

        //кнопка Назад Начало
        Button btn_back = findViewById(R.id.buttonback);
        btn_back.setOnClickListener(view -> {
            //Обрабатываем нажатие кнопки назад НАЧАЛО
            try {
                //Вернуться назад к выбору уровня НАЧАЛО
                Intent intent = new Intent(Level1.this, GameLevel.class);//Создал намерени для перехода
                startActivity(intent);//Старт Намерения
                finish();
                //Вернуться назад к выбору уровня КОНЕЦ

            } catch (Exception e) {

            }
            //Обрабатываем нажатие кнопки назад КОНЕЦ
        });
        //Кнопка Назад Конец

        //Массив для прогресса игры начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10
        };
        //Массив для прогресса игры конец

        //Подключение Анимации - Начало
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        //Поключение Анимации - Конец

        img_left.setImageResource(array.images1[num1]);// достаем из массива картинку
        img_left1.setImageResource(array.images1[num2]);// достаем из массива картинку
        img_bottom.setImageResource(array.images1[num3]);// достаем из массива картинку
        img_bottom1.setImageResource(array.images1[num4]);// достаем из массива картинку


        img_left1.setOnTouchListener((v, event) -> {
            // условия касания картинки - начало
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //если коснулся экрана - начало
                boolean enable = false;
                img_left.setEnabled(enable);//блокировка другого варианта
                img_bottom.setEnabled(enable);//блокировка другого варианта
                img_bottom1.setEnabled(enable);//блокировка другого варианта
                img_left1.setImageResource(R.drawable.img_true);

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //Если отпустил палец начало
                if (img_left1.isPressed()) {
                    if (count < 10) {
                        count = count + 1;
                    }
                    //Серый прогресс Начало
                    for (int i = 0; i < 10; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    //Серый прогресс Конец

                    //Определяем правильные ответы и закрашиваем зеленым цветом - Начало
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }

                    //Определяем правильные ответы и закрашиваем зеленым цветом - Конец
                }
                //Если отпустил палец конец

            }

            // условия касания картинки - конец
            return true;
        });
    }

    //Системная кнопка Назад Начало
    @Override
    public void onBackPressed() {
        //Обрабатываем нажатие кнопки назад НАЧАЛО
        try {
            //Вернуться назад к выбору уровня НАЧАЛО
            Intent intent = new Intent(Level1.this, GameLevel.class);//Создал намерени для перехода
            startActivity(intent);//Старт Намерения
            finish();
            //Вернуться назад к выбору уровня КОНЕЦ

        } catch (Exception e) {

        }
        //Обрабатываем нажатие кнопки назад КОНЕЦ
    }
    //Системная кнопка Назад КОНЕЦ
}
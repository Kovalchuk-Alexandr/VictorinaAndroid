package com.itproger.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView question_label;
    private Button btn_next, btn_correct, btn_incorrect;
    private int question_index = 0, count_correct_answer = 0;

    private Question[] questions = new Question[] {
        new Question(true, R.string.question_1),
        new Question(false, R.string.question_2),
        new Question(true, R.string.question_3),
        new Question(true, R.string.question_4),
        new Question(false, R.string.question_5)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_label = findViewById(R.id.question_label);
        btn_correct = findViewById(R.id.btn_correct);
        btn_incorrect = findViewById(R.id.btn_incorrect);
        btn_next = findViewById(R.id.btn_next);

        // Устанавливаем в поле вопрос
        question_label.setText(questions[question_index].getQuestion());

        // Создаем обработчик нажатия кнопки
        btn_correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Если нажадат кнопка "Верно", возвращаем true
                checkAnswer(true);
            }
        });

        // Создаем обработчик нажатия кнопки
        btn_incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Если нажадат кнопка "Верно", возвращаем true
                checkAnswer(false);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Если вопрос не крайний
                if(question_index != questions.length-1) {
                    // Берем следующий вопрос
                    question_index++;

                    // Устанавливаем в поле вопрос
                    question_label.setText(questions[question_index].getQuestion());

                    // Скрываем кнопку "следующий вопрос", показываем "верно/неверно"
                    btn_next.setVisibility(View.INVISIBLE);
                    btn_correct.setVisibility(View.VISIBLE);
                    btn_incorrect.setVisibility(View.VISIBLE);
                } else {
                    // Если крайний вопрос, выводим результат
                    question_label.setText("Вы все прошли! Результат: " + count_correct_answer + "/" + questions.length);
                    question_label.setTextColor(Color.GREEN);   // Меняем цвет текста
                    btn_next.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void checkAnswer(boolean answer) {
        if(answer == questions[question_index].isCorrect()){
            Toast.makeText(this, "Вы молодец, все верно", Toast.LENGTH_SHORT).show();
            count_correct_answer++;
        } else {
            Toast.makeText(this, "Вы ответили не верно", Toast.LENGTH_SHORT).show();
        }
        btn_next.setVisibility(View.VISIBLE);
        btn_correct.setVisibility(View.INVISIBLE);
        btn_incorrect.setVisibility(View.INVISIBLE);
    }
}
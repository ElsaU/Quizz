package com.example.quizzcds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizzcds.R;
import com.example.quizzcds.classes.Question;
import com.example.quizzcds.classes.QuestionsList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuizzActivity extends AppCompatActivity {
    TextView questionBox;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioGroup radioGroup;
    Button nextButton;

    List<Question> questionsList;
    List<Question> mixQuestionsList;

    int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        questionBox = findViewById(R.id.questionBox);
        option1 = findViewById(R.id.radioButton1);
        option2 = findViewById(R.id.radioButton2);
        option3 = findViewById(R.id.radioButton3);
        option4 = findViewById(R.id.radioButton4);
        radioGroup = findViewById(R.id.radioGroup);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });

        questionsList = QuestionsList.getQuestionsList();
        Collections.shuffle(questionsList);
        questionNumber = 0;

        showQuestions();
    }

    private void showQuestions() {
        System.out.println(questionsList.get(0).getQuestion());

        questionBox.setText(questionsList.get(questionNumber).getQuestion());
        option1.setText(questionsList.get(questionNumber).getOption1());
        option2.setText(questionsList.get(questionNumber).getOption2());
        option3.setText(questionsList.get(questionNumber).getOption3());
        option4.setText(questionsList.get(questionNumber).getOption4());
    }

    private void checkAnswer(){
        radioGroup.getCheckedRadioButtonId();
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton1:
                System.out.println("111111111111111111");
                System.out.println(questionsList.get(questionNumber).getOption1());
                break;
            case R.id.radioButton2:
                System.out.println("22222222222222222222");
                System.out.println(questionsList.get(questionNumber).getOption2());
                break;
            case R.id.radioButton3:
                System.out.println("333333333333333333333");
                System.out.println(questionsList.get(questionNumber).getOption3());
                break;
            case R.id.radioButton4:
                System.out.println("4444444444444444444444");
                System.out.println(questionsList.get(questionNumber).getOption4());
                break;
            default:
                System.out.println("00000000000000000000000000");
                break;
        }
    }

}
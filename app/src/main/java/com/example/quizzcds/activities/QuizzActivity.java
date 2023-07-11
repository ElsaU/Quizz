package com.example.quizzcds.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizzcds.R;
import com.example.quizzcds.classes.Question;
import com.example.quizzcds.classes.QuestionsList;

import java.util.Collections;
import java.util.List;

public class QuizzActivity extends AppCompatActivity {
    ImageView backArrow;
    TextView textQuestionNumber;

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

    CountDownTimer timeNextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        backArrow = findViewById(R.id.backArrow);
        textQuestionNumber = findViewById(R.id.textQuestionNumber);

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

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        questionsList = QuestionsList.getQuestionsList();
        Collections.shuffle(questionsList);
        questionNumber = 0;

        showQuestions();
    }

    private void showQuestions() {
        if (questionNumber < questionsList.size()){
            textQuestionNumber.setText(questionNumber+1 +"/" + questionsList.size());
            questionBox.setText(questionsList.get(questionNumber).getQuestion());
            option1.setText(questionsList.get(questionNumber).getOption1());
            option2.setText(questionsList.get(questionNumber).getOption2());
            option3.setText(questionsList.get(questionNumber).getOption3());
            option4.setText(questionsList.get(questionNumber).getOption4());
        }else {

        }
    }

    private void checkAnswer(){
        radioGroup.getCheckedRadioButtonId();
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton1:
                if (questionsList.get(questionNumber).getOption1().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                }else {
                    option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton2:
                if (questionsList.get(questionNumber).getOption2().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                }else {
                    option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton3:
                if (questionsList.get(questionNumber).getOption3().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                }else {
                    option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton4:
                if (questionsList.get(questionNumber).getOption4().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option4.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                }else {
                    option4.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            default:

                break;
        }
        timeNextQuestion();
    }

    private void timeNextQuestion(){
        timeNextQuestion = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
                option1.setClickable(false);
                option2.setClickable(false);
                option3.setClickable(false);
                option4.setClickable(false);
                showCorrectAnswer();
            }

            @Override
            public void onFinish() {
                questionNumber++;
                showQuestions();
                clearOptions();
            }
        }.start();

    }

    private void showCorrectAnswer(){
        String correctAnswer = questionsList.get(questionNumber).getCorrectAnswer();
        if (correctAnswer.equals(option1.getText().toString())){
            option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
        }else if (correctAnswer.equals(option2.getText().toString())){
            option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
        }else if (correctAnswer.equals(option3.getText().toString())){
            option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
        }else {
            option4.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
        }
    }

    private void clearOptions(){
        radioGroup.clearCheck();
        option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.radio_button, null));
        option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.radio_button, null));
        option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.radio_button, null));
        option4.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.radio_button, null));

        option1.setClickable(true);
        option2.setClickable(true);
        option3.setClickable(true);
        option4.setClickable(true);
    }

    @Override
    public void onBackPressed(){

    }
}
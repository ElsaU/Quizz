package com.example.quizz.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizz.R;
import com.example.quizz.classes.Question;
import com.example.quizz.classes.QuestionsList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizzActivity extends AppCompatActivity {
    ImageView backArrow;
    TextView textQuestionNumber;
    TextView textClock;

    TextView questionBox;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioGroup radioGroup;
    Button nextButton;

    List<Question> questionsList;

    int questionNumber;
    int correctAnswers;

    CountDownTimer timeNextQuestion;
    CountDownTimer timeQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        backArrow = findViewById(R.id.backArrow);
        textQuestionNumber = findViewById(R.id.textQuestionNumber);
        textClock = findViewById(R.id.textClock);

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
                timeQuestion.cancel();
                checkAnswer();
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeQuestion.cancel();
                finish();
            }
        });

        startQuizz();
    }

    private void startQuizz(){
        questionsList = QuestionsList.getQuestionsList();
        Collections.shuffle(questionsList);
        questionNumber = 0;
        correctAnswers = 0;

        showQuestions();
    }

    private void showQuestions() {
        if (questionNumber < questionsList.size()){
            ArrayList<String> optionsList = new ArrayList<>();
            optionsList.add(questionsList.get(questionNumber).getOption1());
            optionsList.add(questionsList.get(questionNumber).getOption2());
            optionsList.add(questionsList.get(questionNumber).getOption3());
            optionsList.add(questionsList.get(questionNumber).getOption4());
            Collections.shuffle(optionsList);

            textQuestionNumber.setText(questionNumber+1 +"/" + questionsList.size());
            questionBox.setText(questionsList.get(questionNumber).getQuestion());
            option1.setText(optionsList.get(0));
            option2.setText(optionsList.get(1));
            option3.setText(optionsList.get(2));
            option4.setText(optionsList.get(3));

            timeQuestion();
        }else {
            finishQuizz();
        }
    }

    private void checkAnswer(){
        radioGroup.getCheckedRadioButtonId();
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton1:
                if (option1.getText().toString().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                    correctAnswers++;
                }else {
                    option1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton2:
                if (option2.getText().toString().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                    correctAnswers++;
                }else {
                    option2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton3:
                if (option3.getText().toString().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                    correctAnswers++;
                }else {
                    option3.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.incorrect_answer, null));
                }
                break;
            case R.id.radioButton4:
                if (option4.getText().toString().equals(questionsList.get(questionNumber).getCorrectAnswer())){
                    option4.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_answer, null));
                    correctAnswers++;
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
                nextButton.setClickable(false);
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

    private void timeQuestion(){
        timeQuestion = new CountDownTimer(16000, 1000) {
            @Override
            public void onTick(long restTime) {
                if (((int)restTime / 1000) < 10){
                    textClock.setText("00:0" + String.valueOf(restTime / 1000));
                }else{
                    textClock.setText("00:" + String.valueOf(restTime / 1000));
                }
            }

            @Override
            public void onFinish() {
                if (questionNumber == questionsList.size()){
                    finishQuizz();
                }else {
                    checkAnswer();
                }
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
        nextButton.setClickable(true);
    }

    private void finishQuizz(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final Context context = alert.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View v = inflater.inflate(R.layout.layout_finish_quizz, null, false);

        final TextView finalCorrectAnswers = v.findViewById(R.id.textFinalCorrectAnswers);
        finalCorrectAnswers.setText("¡Has acertado " + correctAnswers +"/" + questionsList.size() +" preguntas!");

        alert.setView(v).
                setCancelable(false);

        final AlertDialog dialog = alert.show();
        TextView dialogButtonVolverAJugar = v.findViewById(R.id.buttonPlayAgain);
        dialogButtonVolverAJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTime();
                startQuizz();
                dialog.dismiss();
            }
        });
        TextView dialogButtonSalir = v.findViewById(R.id.buttonExit);
        dialogButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTime();
                dialog.dismiss();
                finish();
            }
        });
    }

    private void cancelTime(){
        timeQuestion.cancel();
        timeNextQuestion.cancel();
    }
    @Override
    public void onBackPressed(){

    }
}
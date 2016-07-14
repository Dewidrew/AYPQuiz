package com.augmentis.ayp.aypquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    Button trueButton, falseButton, nextButton;
    TextView questionText;
    Question[] questions = new Question[]{
            new Question(R.string.question_1_nile, true),
            new Question(R.string.question_2_rawin, true),
            new Question(R.string.question_3_math, false),
            new Question(R.string.question_4_mar, false),
    };
    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);

        questionText = (TextView) findViewById(R.id.text_question);

        //Initial Question
        currentIndex = 0;
        questionText.setText(questions[currentIndex].getQuestionId());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });


        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();

            }
        });
    }

    private void updateQuestion() {
        questionText.setText(questions[++currentIndex%questions.length].getQuestionId());
    }

    private void checkAnswer(boolean answer) {
        boolean correct = questions[currentIndex%4].getAnswer();
        if (answer == correct) {
            Toast.makeText(QuizActivity.this, R.string.correct_text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_text, Toast.LENGTH_SHORT).show();
        }
    }

}

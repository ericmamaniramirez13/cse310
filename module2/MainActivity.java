package com.example.mathappmodule2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.widget.Button start_button, answer1, answer2, answer3, answer4;
    android.widget.TextView text_timer, text_score, text_questions, bottom_message;
    android.widget.ProgressBar bar_timer;

    Game g = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = findViewById(R.id.start_button);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        text_score = findViewById(R.id.text_score);
        bottom_message = findViewById(R.id.bottom_message);
        text_questions = findViewById(R.id.text_questions);
        text_timer = findViewById(R.id.text_timer);

        bar_timer = findViewById(R.id.bar_timer);

        text_timer.setText("0Sec");
        text_questions.setText("");
        bottom_message.setText("Press Go");
        text_score.setText("0pts");

        View.OnClickListener startButtonClickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Button start_button = (android.widget.Button) v;
                start_button.setVisibility(View.INVISIBLE);
                next_problems();
            }
        };

        start_button.setOnClickListener(startButtonClickListener);

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Button button_clicked = (android.widget.Button) v;
                int answered_selected = Integer.parseInt(button_clicked.getText().toString());

                //Toast.makeText(MainActivity.this,"AnsweredSelected"+answered_selected, Toast.LENGTH_SHORT).show();
                g.check_answer(answered_selected);
                text_score.setText(Integer.toString(g.getTotal_score()));
                next_problems();
            }
        };
        answer1.setOnClickListener(answerButtonClickListener);
        answer2.setOnClickListener(answerButtonClickListener);
        answer3.setOnClickListener(answerButtonClickListener);
        answer4.setOnClickListener(answerButtonClickListener);
    }

    public void next_problems() {
        //Create a new question
        //Set text on answer buttons
        //enable answer buttons
        //start the timer
        g.new_question();
        int [] answer = g.getCurrent_question().getFalse_answers();
        answer1.setText(Integer.toString(answer[0]));
        answer2.setText(Integer.toString(answer[1]));
        answer3.setText(Integer.toString(answer[2]));
        answer4.setText(Integer.toString(answer[3]));

        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);
        answer4.setEnabled(true);

        text_questions.setText(g.getCurrent_question().getQuestion_Phrase());
    }
}
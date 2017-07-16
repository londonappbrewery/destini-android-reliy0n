package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: MY CODE
    Button btnFirst;
    Button btnSecond;
    TextView txtviewQuestion;

    int questionNum;
    questions question[] = new questions[]{
            new questions(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new questions(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new questions(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new questions(R.string.T4_End,0,0),
            new questions(R.string.T5_End,0,0),
            new questions(R.string.T6_End,0,0),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            questionNum = 0;
        }
        else{
            questionNum  = savedInstanceState.getInt("questonKey");
        }


        btnFirst = (Button) findViewById(R.id.buttonTop);
        btnSecond = (Button) findViewById(R.id.buttonBottom);
        txtviewQuestion = (TextView) findViewById(R.id.storyTextView);

        txtviewQuestion.setText(question[questionNum].question);
        if(questionNum < 3) {
            btnFirst.setText(question[questionNum].firstAnsw);
            btnSecond.setText(question[questionNum].secondAnsw);
        }
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestion(1);
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestion(2);
            }
        });


    }

    private void getQuestion(int answer){
        System.out.println("SpeakBefore:"+questionNum);
        questionNum = findQNumber(questionNum,answer);
        System.out.println("Speak:"+questionNum);
        txtviewQuestion.setText(question[questionNum].question);
        if(questionNum < 3) {
            btnFirst.setText(question[questionNum].firstAnsw);
            btnSecond.setText(question[questionNum].secondAnsw);
        }

    }

    public int findQNumber(int qNumber, int answer){
        if(qNumber == 0){
            if(answer == 1){
                //3
                return 2;
            }
            else if(answer == 2){
                //2
                return 1;
            }
        }
        else if(qNumber == 1){

            if(answer == 1){
                //3
                return 2;
            }
            else if(answer == 2){
                //4
                return 3;
            }

        }
        else if(qNumber == 2){

            if(answer == 1){
                //6
                return 5;
            }
            else if(answer == 2){
                //5
                return 4;
            }

        }
        else{
            return 0;
        }
        return 0;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("questonKey",questionNum);
    }


}


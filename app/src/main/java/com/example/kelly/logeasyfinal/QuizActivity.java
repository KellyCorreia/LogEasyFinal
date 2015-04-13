package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;


public class QuizActivity extends Activity {
    List<QuestionClass> qList;
    QuestionClass curQuest;
    TextView txtQuest;
    RadioButton rda, rdb, rdc;
    Button butNext;
    MySQLiteHelper db = new MySQLiteHelper(this);
    ScoreboardClass scoreUser;
    UserClass user2;

    int score = 0;
    int qid = 0;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        scoreUser = (ScoreboardClass) extras.getParcelable("LessonUser");

        txtQuest =(TextView)findViewById(R.id.txtQuestion);
        rda=(RadioButton)findViewById(R.id.radioA);
        rdb=(RadioButton)findViewById(R.id.radioB);
        rdc=(RadioButton)findViewById(R.id.radioC);
        butNext=(Button)findViewById(R.id.btnNext);

        setQuestion();

        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroupAnswers);
                RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", curQuest.getRight_answer() + " " + answer.getText());
                if(curQuest.getRight_answer().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score" + score);
                }

                switch (v.getId()) {
                    case R.id.btnLesson:

                        intent.setClass(QuizActivity.this, LessonActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnHint:
                        intent.setClass(QuizActivity.this, HintActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:
                        intent.setClass(QuizActivity.this, QuizActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
                /*if(qid<5){
                    curQuest = qList.get(qid);
                    setQuestionView();
                }else{
                    if(v.findViewById(R.id.btnLesson){}
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle bu = new Bundle();
                    bu.putInt("score", score); //Your score
                    intent.putExtras(bu); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                 }*/
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    private void setQuestionView()
    {
        txtQuest.setText(curQuest.getQuestion_text());
        //rda.setText(curQuest.getOa());
        //rdb.setText(curQuest.getOb());
        //rdc.setText(curQuest.getOc());
        qid++;
    }

    private void setQuestion(){
        qList = db.getAllQuestions();


        curQuest = qList.get(qid);
    }



}

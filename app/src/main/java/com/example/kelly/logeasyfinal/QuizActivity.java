package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;


public class QuizActivity extends Activity {
    List<Question> qList;
    int score=0;
    int qid=0;
    Question curQuest;
    TextView txtQuest;
    RadioButton rda, rdb, rdc;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        MySQLiteHelper db = new MySQLiteHelper(this);
        qList = db.getAllQuestions();
        curQuest = qList.get(qid);
        txtQuest =(TextView)findViewById(R.id.question);
        rda=(RadioButton)findViewById(R.id.a);
        rdb=(RadioButton)findViewById(R.id.b);
        rdc=(RadioButton)findViewById(R.id.c);
        butNext=(Button)findViewById(R.id.next);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.answers);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", curQuest.getRight_answer() + " " + answer.getText());
                if(curQuest.getRight_answer().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<5){
                    curQuest = qList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle bu = new Bundle();
                    bu.putInt("score", score); //Your score
                    intent.putExtras(bu); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
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



}

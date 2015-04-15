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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizActivity extends Activity {
    List<QuestionClass> qList = new ArrayList<>();
    List<AnswerClass> aList;
    QuestionClass curQuest;
    TextView txtQuest, txtPoints;
    RadioGroup grp;
    RadioButton rda, rdb, rdc;
    Button butNext, btnLesson, btnHint;
    ScoreboardClass scoreUser;
    String selecLevel;
    RadioButton rightAnswer,userAnswer;

    int score = 0;
    int qid = 0;
    Intent intent = new Intent();
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        scoreUser = extras.getParcelable("LessonUser");
        selecLevel = extras.getString("chosenLevel");
        score = scoreUser.getPoints();

        txtPoints = (TextView)findViewById(R.id.txtPoints);
        txtQuest =(TextView)findViewById(R.id.txtQuestion);
        grp=(RadioGroup)findViewById(R.id.radioGroupAnswers);
        rda=(RadioButton)findViewById(R.id.radioA);
        rdb=(RadioButton)findViewById(R.id.radioB);
        rdc=(RadioButton)findViewById(R.id.radioC);
        butNext=(Button)findViewById(R.id.btnNext);
        btnHint = (Button)findViewById(R.id.btnHint);
        btnLesson = (Button)findViewById(R.id.btnLesson);

        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                if(userAnswer == rightAnswer){
                    Toast.makeText(QuizActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    score += 10;

                }
                //Log.d("yourans", curQuest.getRight_answer() + " " + answer.getText());
                //if(curQuest.getRight_answer().equals(answer.getText()))
                //{
                  //  score++;
                    //Log.d("score", "Your score" + score);
                //}

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

    private void setQuestionView(){
        Random rd = new Random();
        int rdQ;

        if(qList.size() >= 0){
            qList = db.levelQuestion(selecLevel);
        }

        rdQ = rd.nextInt(qList.size());
        aList = db.getAnswer(qList.get(rdQ).getQuestion_id());

        txtQuest.setText(qList.get(rdQ).getQuestion_text());
        rda.setText(aList.get(0).getAnswer_text());
        rdb.setText(aList.get(1).getAnswer_text());
        rdc.setText(aList.get(2).getAnswer_text());
        if(qList.get(rdQ).getRight_answer() == aList.get(0).getAnswer_id()) {
            rightAnswer = rda;
        }else{
            if(qList.get(rdQ).getRight_answer() == aList.get(1).getAnswer_id()){
                rightAnswer = rdb;
            }else{
                rightAnswer = rdc;
            }
        }
        //qList.remove(rdQ);
        qid++;
    }


}

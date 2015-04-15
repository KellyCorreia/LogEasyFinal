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
    TextView txtQuest, txtPoints;
    RadioGroup grp;
    RadioButton rda, rdb, rdc;
    Button butNext, btnLesson, btnHint;
    ScoreboardClass Score;
    UserClass User;
    LevelClass selecLevel;
    RadioButton rightAnswer,userAnswer;

    int score = 0;
    MySQLiteHelper db = new MySQLiteHelper(this);
    int rdQ;
    int qid = 0;
    Intent intent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        User = (UserClass)extras.getParcelable("chosenUser");
        selecLevel = (LevelClass)extras.getParcelable("chosenLevel");
        Score = (ScoreboardClass)extras.getParcelable("userScore");
        score = Score.getPoints();

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
                qList.remove(rdQ);
                if(userAnswer == rightAnswer){
                    Toast.makeText(QuizActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    score += 10;
                    //db.updatingScore(score, User);
                    //Score = db.getScore(User.getUser_id());
                    switch(score){
                        case 50:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Wind element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L02");
                            break;
                        case 100:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Sound element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L03");
                            break;
                        case 150:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Metal element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L04");
                            break;
                        case 200:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Sand element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L05");
                            break;
                        case 250:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Snow element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L06");
                            break;
                        case 300:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Plant element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L07");
                            break;
                        case 350:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Lighting element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L08");
                            break;
                        case 400:
                            Toast.makeText(QuizActivity.this, "Congratulations! You master the Lava element!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L09");
                            break;
                        case 450:
                            Toast.makeText(QuizActivity.this, "Congratulations! You defeated the Dark City!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L10");
                            break;
                        case 500:
                            Toast.makeText(QuizActivity.this, "Congratulations! You are the master of the World!", Toast.LENGTH_SHORT).show();
                            db.updatingScore(score, User, "L10");
                            break;
                        default:
                            db.updatingScore(score, User, "L10");


                    }
                    setQuestionView();

                }
                //Log.d("yourans", curQuest.getRight_answer() + " " + answer.getText());
                //if(curQuest.getRight_answer().equals(answer.getText()))
                //{
                  //  score++;
                    //Log.d("score", "Your score" + score);
                //}
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
        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(QuizActivity.this, HintActivity.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userScore", Score);
                startActivity(intent);
            }
        });

        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(QuizActivity.this, LessonActivity.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userScore", Score);
                startActivity(intent);
            }
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
        MySQLiteHelper db = new MySQLiteHelper(this);
        int rdQ;

        if(qList.size() >= 0){
            qList = db.levelQuestion(selecLevel.getLevel_id());
        }

        rdQ = rd.nextInt(qList.size());
        aList = db.getAnswer(qList.get(rdQ).getQuestion_id());

        txtQuest.setText(qList.get(rdQ).getQuestion_text());
        rda.setText(aList.get(0).getAnswer_text());
        rdb.setText(aList.get(1).getAnswer_text());
        rdc.setText(aList.get(2).getAnswer_text());
        if(qList.get(rdQ).getRight_answer() == aList.get(0).getAnswer_id()) {
            rightAnswer = rda;
        }else {
            if (qList.get(rdQ).getRight_answer() == aList.get(1).getAnswer_id()) {
                rightAnswer = rdb;
            } else {
                rightAnswer = rdc;
            }
        }
        //qid++;
    }


}

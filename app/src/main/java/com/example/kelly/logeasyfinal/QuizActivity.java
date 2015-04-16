package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends Activity {
    List<QuestionClass> qList = new ArrayList<>();
    List<AnswerClass> aList = new ArrayList<>();
    TextView txtQuest, txtPoints;
    RadioGroup grp;
    RadioButton rda, rdb, rdc;
    Button butNext, btnLesson, btnHint;
    RelativeLayout layout;
    RadioButton rightAnswer,userAnswer;
    ScoreboardClass Score;
    UserClass User;
    LevelClass selecLevel;
    Intent intent = new Intent();
    MySQLiteHelper db;

    int score;
    int rdQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        db = new MySQLiteHelper(this);

        Bundle extras = getIntent().getExtras();
        User = (UserClass)extras.getParcelable("chosenUser");
        selecLevel = (LevelClass)extras.getParcelable("chosenLevel");
        Score = (ScoreboardClass)extras.getParcelable("userscore");
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
        layout = (RelativeLayout)findViewById(R.id.layoutQuiz);

        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((rda.isChecked()) || (rdb.isChecked()) || (rdc.isChecked())) {
                    userAnswer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                    createUserActivity();

                    if (userAnswer == rightAnswer) {
                        Toast.makeText(QuizActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                        if (selecLevel.getLevel_id().equals(Score.getLevel_id())) {
                            score += 10;
                            setScoreBoard();
                        }
                    }else {
                        Toast.makeText(QuizActivity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    }
                    grp.clearCheck();
                    setQuestionView();
                }else{
                    Toast.makeText(QuizActivity.this, "Select one option!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(QuizActivity.this, HintActivity.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userscore", Score);
                startActivity(intent);
            }
        });

        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(QuizActivity.this, LessonActivity.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userscore", Score);
                startActivity(intent);
            }
        });
    }


    private void setQuestionView(){

        if(qList.size() == 0) {
            qList = db.levelQuestion(selecLevel.getLevel_id());
        }

        aList = db.getAnswer(qList.get(0).getQuestion_id());

        switch(selecLevel.getLevel_id()){
            case "L01":
                layout.setBackgroundResource(R.drawable.backgroundlevel1);
                break;
            case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                break;
        }


        txtPoints.setText(Integer.toString(Score.getPoints()));
        txtQuest.setText(qList.get(0).getQuestion_text());
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
    }

    private void setScoreBoard(){

        intent.setClass(QuizActivity.this, LevelsActivity.class);
        intent.putExtra("chosenUser", User);


        switch(score) {
            case 50:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Wind element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L02");

                startActivity(intent);
                break;

            case 100:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Sound element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L03");
                startActivity(intent);
                break;

            case 150:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Metal element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L04");
                startActivity(intent);
                break;

            case 200:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Sand element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L05");
                startActivity(intent);
                break;

            case 250:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Snow element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L06");
                startActivity(intent);
                break;

            case 300:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Plant element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L07");
                startActivity(intent);
                break;

            case 350:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Lighting element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L08");
                startActivity(intent);
                break;

            case 400:
                Toast.makeText(QuizActivity.this, "Congratulations! You master the Lava element!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L09");
                startActivity(intent);
                break;

            case 450:
                Toast.makeText(QuizActivity.this, "Congratulations! You defeated the Dark City!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L10");
                startActivity(intent);
                break;

            case 500:
                Toast.makeText(QuizActivity.this, "Congratulations! You are the master of the World!", Toast.LENGTH_SHORT).show();
                db.updatingScore(score, User, "L10");
                startActivity(intent);
                break;

            default:
                db.updatingScore(score, User, Score.getLevel_id());
                break;
        }
        Score = db.getScore(User.getUser_id());
    }

    private void createUserActivity(){
        UserActivityClass userActivity = new UserActivityClass();
        String aID = "";

        for(int i = 0; i < aList.size();i++){
            if(userAnswer.getText() == aList.get(i).getAnswer_text()){
                aID = aList.get(i).getAnswer_id();
                break;
            }
        }

        userActivity.setUser_id(User.getUser_id());
        userActivity.setQuestion_id(qList.get(0).getQuestion_id());
        userActivity.setAnswer_id(aID);
        db.addUserActivity(userActivity);
        qList.remove(0);

    }


}

package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LessonActivity extends Activity {
    TextView txtPoints;
    TextView txtLesson;
    Button btnPlay;
    ImageView ImgAvatar;
    RelativeLayout layout;
    LinearLayout firstLayout;
    ScrollView scrollLesson;
    String selecLevel;
    LevelClass curLevel;
    UserClass User;
    ScoreboardClass Score;
    Random rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Bundle extras = getIntent().getExtras();
        User = extras.getParcelable("chosenUser");
        selecLevel = extras.getString("chosenLevel");

        txtPoints = (TextView)findViewById(R.id.txtPoints);
        txtLesson =(TextView)findViewById(R.id.txtLesson);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        ImgAvatar = (ImageView)findViewById(R.id.imageViewAvatar);
        layout = (RelativeLayout)findViewById(R.id.relativeLayoutLesson);
        firstLayout = (LinearLayout)findViewById(R.id.linearLayoutFirst);
        scrollLesson = (ScrollView)findViewById(R.id.scrollViewLesson);

        this.getCurrent();
        this.setLesson();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("LessonUser", Score);
                startActivity(intent);
            }
        });
    }

    private void setLesson(){ //Method to take the lesson from the Level Class and from the User Class
        txtPoints.setText(Integer.toString(Score.getPoints()));
        txtLesson.setText(curLevel.getLesson());
        scrollLesson.setBackgroundResource(R.drawable.ballonlevel);

        switch (User.getAvatar()){
            case "Avatar1":
                int random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar12);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar13);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar14);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar15);
                        }
                    }
                }
                break;

            case "Avatar2":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar22);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar23);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar24);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar25);
                        }
                    }
                }
                break;

            case "Avatar3":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar32);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar33);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar34);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar35);
                        }
                    }
                }
                break;

            case "Avatar4":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar42);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar43);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar44);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar45);
                        }
                    }
                }
                ImgAvatar.setImageResource(R.drawable.avatar4);
                break;
        }

        switch(selecLevel){
            case "L01":
                //layout.setBackgroundResource(R.drawable.backgroundlevel1);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel);
                break;
           /* case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel10);
                break; case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel10);
                break; case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel10);
                break; case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                firstLayout.setBackgroundColor(Color.BLUE);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel10);
                break;*/
        }

    }

    private void getCurrent(){
        MySQLiteHelper db = new MySQLiteHelper(this);

        curLevel = db.getLevel(selecLevel);
        Score = db.getScore(User.getUser_id());
    }

}

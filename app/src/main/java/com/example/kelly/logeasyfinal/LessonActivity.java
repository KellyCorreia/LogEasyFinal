package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class LessonActivity extends Activity {
    TextView txtPoints;
    TextView txtLesson;
    Button btnPlay;
    ImageView ImgAvatar;
    String selecLevel, userLevel;
    LevelClass curLevel;
    UserClass User;
    ScoreboardClass Score;
    MySQLiteHelper db = new MySQLiteHelper(this);


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

        this.getCurrent();
        this.setLesson();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
                //intent.putExtra("LessonUser", Score);
               // startActivity(intent);
            }
        });
    }

    private void setLesson(){ //Method to take the lesson from the Level Class and from the User Class
        txtPoints.setText(Integer.toString(db.getScore(User.getUser_id())));
        txtLesson.setText((String)curLevel.getLesson());
        switch (User.getAvatar()){
            case "Avatar1":
                ImgAvatar.setImageResource(R.drawable.avatar1);
                break;
            case "Avatar2":
                ImgAvatar.setImageResource(R.drawable.avatar2);
                break;
            case "Avatar3":
                ImgAvatar.setImageResource(R.drawable.avatar3);
                break;
            case "Avatar4":
                ImgAvatar.setImageResource(R.drawable.avatar4);
                break;
        }
    }

    private void getCurrent(){
        MySQLiteHelper db = new MySQLiteHelper(this);

        curLevel = db.getLevel(selecLevel);
        //Score = db.getScore(User.getUser_id());
    }

}

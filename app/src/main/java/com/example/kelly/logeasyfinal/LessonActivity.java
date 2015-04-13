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

import java.util.ArrayList;
import java.util.List;


public class LessonActivity extends Activity {
    TextView txtPoints;
    TextView txtLesson;
    Button btnPlay;
    ImageView ImgAvatar;
    MySQLiteHelper db = new MySQLiteHelper(this);
    LevelClass curLevel;
    UserClass User;
    ScoreboardClass Score;
    UserClass user2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Bundle extras = getIntent().getExtras();
        User = (UserClass) extras.getParcelable("chosenUser");

        txtPoints = (TextView)findViewById(R.id.txtPoints);
        txtLesson =(TextView)findViewById(R.id.txtLesson);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        ImgAvatar = (ImageView)findViewById(R.id.imageViewAvatar);
        getCurrentLevel();
        setLesson();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
                intent.putExtra("LessonUser", Score);
                startActivity(intent);
            }
        });
    }

    private void setLesson(){ //Method to take the lesson from the Level Class and from the User Class
        txtPoints.setText(Score.getPoints());
        txtLesson.setText(curLevel.getLesson());
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

    private void getCurrentLevel(){
        List<LevelClass> levelslist = new ArrayList<>();
        List<ScoreboardClass> scorelist = new ArrayList<>();
        String levelUser = "L01";

        levelslist = db.getAllLevels();
        scorelist = db.getAllScoreboard();
        for(int i=0;i < scorelist.size();i++){
            if(scorelist.get(i).getUser_id() == User.getUser_id()) {
                levelUser = scorelist.get(i).getLevel_id();
                Score = scorelist.get(i);
                break;
            }
        }

        for(int i=0; i<levelslist.size();i++){
            if(levelslist.get(i).getLevel_id() == levelUser){
                curLevel = levelslist.get(i);
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

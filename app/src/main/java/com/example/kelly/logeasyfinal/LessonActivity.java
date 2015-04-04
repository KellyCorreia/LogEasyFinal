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


public class LessonActivity extends Activity {
    TextView txtLesson;
    Button btnPlay;
    ImageView ImgAvatar;
    Drawable draw;
    MySQLiteHelper db = new MySQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        txtLesson =(TextView)findViewById(R.id.txtLesson);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        ImgAvatar = (ImageView)findViewById(R.id.imageViewAvatar);
        setLesson();
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson, menu);
        return true;
    }

    private void setLesson(){ //Method to take the lesson from the Lesson Class and from the User Class
        //txtLesson.setText(.getQuestion_text());
        //ImgAvatar.setImageDrawable();
        //draw = (Drawable)image
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

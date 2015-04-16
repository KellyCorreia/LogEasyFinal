package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.kelly.logeasyfinal.Constant.FIRST_COLUMN;
import static com.example.kelly.logeasyfinal.Constant.SECOND_COLUMN;
import static com.example.kelly.logeasyfinal.Constant.THIRD_COLUMN;
import static com.example.kelly.logeasyfinal.Constant.FOURTH_COLUMN;



public class Scoreboard_Activity extends Activity {
    private ScoreboardClass scoreBoard;
    private UserClass user;
    private List<UserClass> userList;
    private MySQLiteHelper dbHelper;
    private ArrayList<ScoreboardScreen> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_);

        ListView lview = (ListView) findViewById(R.id.listview);
        populateList();
        listviewAdapter adapter = new listviewAdapter(this, list);
        lview.setAdapter(adapter);
    }

   private void populateList() {
       String userName, levelName;
       int points, wrongNum, totalAnswers;
       long userId;
       double wrongPerc;

       dbHelper = new MySQLiteHelper(this);
       userList = dbHelper.getAllUsers();

       dbHelper.deleteScoreboardTable();

       for (int i = 0; i < userList.size(); i++){
           user = userList.get(i);
           userId = user.getUser_id();
           userName = user.getUsername();
           levelName = dbHelper.getUserLevel(userId);
           scoreBoard = dbHelper.getScore(userId);
           points = scoreBoard.getPoints();
           wrongNum = scoreBoard.getWrong_percent();
           totalAnswers = wrongNum + (points/10);
           wrongPerc = 0.0;
           if(totalAnswers != 0){
               wrongPerc = wrongNum/totalAnswers;
           }

           Toast.makeText(Scoreboard_Activity.this, "num Erradas: " + wrongNum + " perc erradas: " + wrongPerc + "Total: " + totalAnswers, Toast.LENGTH_LONG).show();
           ScoreboardScreen scoreboard = new ScoreboardScreen(userName, levelName, points, wrongPerc);

           dbHelper.addScoreboardScreen(scoreboard);
           list = dbHelper.getScoreboardTable();
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoreboard_, menu);
        return true;
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

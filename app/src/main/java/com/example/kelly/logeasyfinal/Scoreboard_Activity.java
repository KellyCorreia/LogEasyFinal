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
        //Toast.makeText(Scoreboard_Activity.this, "Está chamando o score board", Toast.LENGTH_SHORT).show();
        listviewAdapter adapter = new listviewAdapter(this, list);
        lview.setAdapter(adapter);
    }

   private void populateList() {
       String userName, levelName;
       int points, wrongNum, totalAnswers;
       long userId;
       double wrongPerc;

       list = new ArrayList<ScoreboardScreen>();

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
           totalAnswers = wrongNum + (points/100);
           if(totalAnswers == 0){
               wrongPerc = 0.0;
           }else{
               wrongPerc = wrongNum/(wrongNum + (points/10));
           }

           /*String strPoints = String.valueOf(points);
           String strwrong = String.valueOf(wrongPerc);*/

           ScoreboardScreen scoreboard = new ScoreboardScreen(userName, levelName, points, wrongPerc);

           dbHelper.addScoreboardScreen(scoreboard);
           list = dbHelper.getScoreboardTable();

           /*HashMap temp = new HashMap();
           temp.put(FIRST_COLUMN, username);
           temp.put(SECOND_COLUMN, levelName);
           temp.put(THIRD_COLUMN, strPoints);
           temp.put(FOURTH_COLUMN, strwrong);
           list.add(temp);*/

       }


        /*HashMap temp = new HashMap();
        temp.put(FIRST_COLUMN,"Colored Notebooks");
        temp.put(SECOND_COLUMN, "By NavNeet");
        temp.put(THIRD_COLUMN, "Rs. 200");
        temp.put(FOURTH_COLUMN, "Per Unit");
        list.add(temp);

        HashMap temp1 = new HashMap();
        temp1.put(FIRST_COLUMN,"Diaries");
        temp1.put(SECOND_COLUMN, "By Amee Products");
        temp1.put(THIRD_COLUMN, "Rs. 400");
        temp1.put(FOURTH_COLUMN, "Per Unit");
        list.add(temp1);

        HashMap temp2 = new HashMap();
        temp2.put(FIRST_COLUMN,"Note Books and Stationery");
        temp2.put(SECOND_COLUMN, "By National Products");
        temp2.put(THIRD_COLUMN, "Rs. 600");
        temp2.put(FOURTH_COLUMN, "Per Unit");
        list.add(temp2);

        HashMap temp3 = new HashMap();
        temp3.put(FIRST_COLUMN,"Corporate Diaries");
        temp3.put(SECOND_COLUMN, "By Devarsh Prakashan");
        temp3.put(THIRD_COLUMN, "Rs. 800");
        temp3.put(FOURTH_COLUMN, "Per Unit");
        list.add(temp3);

        HashMap temp4 = new HashMap();
        temp4.put(FIRST_COLUMN,"Writing Pad");
        temp4.put(SECOND_COLUMN, "By TechnoTalaktive Pvt. Ltd.");
        temp4.put(THIRD_COLUMN, "Rs. 100");
        temp4.put(FOURTH_COLUMN, "Per Unit");
        list.add(temp4);*/
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

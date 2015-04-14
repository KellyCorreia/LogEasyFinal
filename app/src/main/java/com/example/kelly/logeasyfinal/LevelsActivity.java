package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class LevelsActivity extends Activity {

    private View pointsView;
    private UserClass user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //Getting the object user from the previous screen
        Bundle extras = getIntent().getExtras();
        user = (UserClass) extras.getParcelable("chosenUser");

        //Setting the Label with the userName
        TextView txtViewUsername = (TextView) findViewById(R.id.txtvUsername);
        txtViewUsername.setText(user.getUsername());
        MySQLiteHelper db = new MySQLiteHelper(this);
        String levelName =  db.getUserLevel(Integer.valueOf((int)user.getUser_id()));
        TextView levelView = (TextView) findViewById(R.id.txtvLevel);
        levelView.setText(levelName);

        String Points =  db.getUserPoints(Integer.valueOf((int)user.getUser_id()));
        Toast.makeText(LevelsActivity.this, "Points" + Points, Toast.LENGTH_LONG).show();

        //TextView pointsView = (TextView) findViewById(R.id.txtvPoints);
        //pointsView.setText(Points);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
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

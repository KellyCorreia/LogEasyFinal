package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class LevelsActivity extends Activity {
    private UserClass user;
    private String levelName;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        Button btnLevels;
        TextView pointsView;
        TextView levelView;
        TextView txtViewUsername;
        String Points;

        MySQLiteHelper db = new MySQLiteHelper(this);



        //Getting the object user from the previous screen

        Bundle extras = getIntent().getExtras();
        user = extras.getParcelable("chosenUser");

        Toast.makeText(LevelsActivity.this, "Welcome, " + user.getUsername()+" !", Toast.LENGTH_LONG).show();
        Toast.makeText(LevelsActivity.this, "Choose a Level to start the challenge!", Toast.LENGTH_LONG).show();


        //Setting the Label with the userName
        txtViewUsername = (TextView) findViewById(R.id.txtvUsername);
        txtViewUsername.setText(user.getUsername());

        levelName =  db.getUserLevel(Integer.valueOf((int)user.getUser_id()));

        levelView = (TextView) findViewById(R.id.txtvLevel);
        levelView.setText(levelName);
        Points =  db.getUserPoints(Integer.valueOf((int)user.getUser_id()));

        pointsView = (TextView) findViewById(R.id.txtvPoints);
        pointsView.setText(Points+" Points");

        btnLevels = (Button)findViewById(R.id.imbLevel1);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user,"Level 1 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel2);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 2 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel3);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 3 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel4);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 4 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel5);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 5 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel6);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 6 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel7);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 7 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel8);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 8 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel9);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 9 Name");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel10);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent(user, "Level 10 Name");
            }
        });
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

    public void setIntent(UserClass user, String chosenLevel){
        intent = new Intent(LevelsActivity.this, LessonActivity.class);
        intent.putExtra("chosenUser", user);
        intent.putExtra("chosenLevel", chosenLevel);
        intent.putExtra("userLevel", levelName);
        startActivity(intent);
    }
}

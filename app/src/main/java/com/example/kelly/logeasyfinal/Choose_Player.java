package com.example.kelly.logeasyfinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class Choose_Player extends ActionBarActivity {
    private Button btnnewuser;
    private GridView gridviewusers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__player);

        //these part of this method refer only to the GridView component.
        gridviewusers = (GridView) findViewById(R.id.gridview);
        gridviewusers.setAdapter(new ImageAdapter(this));
        gridviewusers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Choose_Player.this, "" + position,
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Choose_Player.this, LoginActivity.class);
                //These lines refer to the data which need to be passed to login page(image, name and id of the user)
                /*Bundle bu = new Bundle();
                bu.putInt("score", score); //Your score
                intent.putExtras(bu); //Put your score to your next Intent
                */
                startActivity(intent);
                finish();
            }
        });

        btnnewuser = (Button) findViewById(R.id.btnnewuser);
        btnnewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Player.this, Create_User.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose__player, menu);
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

package com.example.kelly.logeasyfinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Create_User extends ActionBarActivity {
    private Button btnsave;
    private String AvatarSelected;
    private String UserName;
    private String Email;
    private String Password;
    private UserClass NewUser;
    private MySQLiteHelper dbHelper;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__user);
        rb1 = (RadioButton) findViewById(R.id.rbtAvatar1);
        rb2 = (RadioButton) findViewById(R.id.rbtAvatar2);
        rb3 = (RadioButton) findViewById(R.id.rbtAvatar3);
        rb4 = (RadioButton) findViewById(R.id.rbtAvatar4);
        GRadioGroup gr = new GRadioGroup(rb1, rb2, rb3, rb4);//This is to do not allow more than one Radio be clicked.
    }

   public void btnCreateOnClick(View view){
       if(rb1.isChecked()){
           AvatarSelected = "Avatar1";
          //Toast.makeText(Create_User.this, "Avatar 1", Toast.LENGTH_SHORT).show();
       }else if(rb2.isChecked()){
           AvatarSelected = "Avatar2";
       }else if(rb3.isChecked()){
           AvatarSelected = "Avatar3";
       }else if(rb4.isChecked()){
           AvatarSelected = "Avatar4";
       }
       EditText txtname;
       txtname = (EditText)findViewById(R.id.txtusername);
       UserName = txtname.getText().toString();
       EditText txtemail;
       txtemail = (EditText)findViewById(R.id.txtemail);
       Email = txtemail.getText().toString();
       EditText txtpass;
       txtpass = (EditText)findViewById(R.id.txtpassword);
       Password = txtpass.getText().toString();

       NewUser = new UserClass(UserName, Email, Password, AvatarSelected);
       dbHelper = new MySQLiteHelper(this);
       dbHelper.addUser(NewUser);

       Toast.makeText(Create_User.this, AvatarSelected + " , " + UserName + " , " + Email + " , " + Password, Toast.LENGTH_SHORT).show();
       Intent intent = new Intent(Create_User.this, LoginActivity.class);
       startActivity(intent);
       finish();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create__user, menu);
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

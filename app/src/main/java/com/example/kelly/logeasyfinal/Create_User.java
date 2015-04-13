package com.example.kelly.logeasyfinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;


public class Create_User extends Activity {
    private String AvatarSelected;
    private String UserName;
    private String Email;
    private String Password;
    MySQLiteHelper dbHelper;
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
       EditText txtemail;
       txtemail = (EditText)findViewById(R.id.txtemail);
       EditText txtpass;
       txtpass = (EditText)findViewById(R.id.txtpassword);

       UserClass user = this.validateFields(txtname, txtemail, txtpass, AvatarSelected);
       if (user != null){

       }

       /*
       if ((UserName!=null) && (Email!=null) && (Password!=null) && (AvatarSelected!=null)) {

           //Toast.makeText(Create_User.this, AvatarSelected + " , " + UserName + " , " + Email + " , " + Password, Toast.LENGTH_SHORT).show();
           NewUser = new UserClass(UserName, Email, Password, AvatarSelected);
           dbHelper = new MySQLiteHelper(this);
           if (dbHelper.addUser(NewUser)){
               Intent intent = new Intent(Create_User.this, LoginActivity.class);
               intent.putExtra("chosenUser", NewUser);
               startActivity(intent);
               finish();
           }
       }
       */

    }

    private UserClass validateFields(EditText txtName, EditText txtEmail, EditText txtPassword, String avatar) {
        boolean nameFound = false;
        boolean emailFound = false;
        List<UserClass> listUsers;
        UserClass user;

        UserName = txtName.getText().toString();
        Email = txtEmail.getText().toString();
        Password = txtPassword.getText().toString();

        listUsers = dbHelper.getAllUsers();
        for (int i = 0; i < listUsers.size(); i++) {
            if (UserName.equals(listUsers.get(i).getUsername())) {
                nameFound = true;
            }
            if (Email.equals(listUsers.get(i).getEmail())) {
                emailFound = true;
            }
        }

        if (UserName == null || nameFound == true) {
            txtName.setError("Choose another User Name!");
            return null;
        } else if (Email == null || emailFound == true) {
            txtEmail.setError("Email not accepted!");
            return null;
        }

        user = new UserClass(UserName, Email, Password, avatar);

        return user;

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

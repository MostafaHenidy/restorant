package com.example.firststep;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar2 = findViewById(R.id.logintoolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_arrow_backup_2_svgrepo_com__1_);
        getSupportActionBar().setTitle("");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void read (View v ){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("SignUp_Data", Context.MODE_PRIVATE);
        String name = preferences.getString("name","no Name");
        String Email = preferences.getString("Email","no Email");
        String Password = preferences.getString("Password","no Password");
    }
    public void signin (View v){
        String Error ="Error Wrong Email ,password or name";
        EditText editTextname = (EditText) findViewById(R.id.namesign);
        EditText editTextemail = (EditText) findViewById(R.id.emailsign);
        EditText editTextpass = (EditText) findViewById(R.id.passwordsign);
        String nameValue  = editTextname.getText().toString();
        String EmailValue  = editTextemail.getText().toString();
        String passValue  = editTextpass.getText().toString();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("SignUp_Data", Context.MODE_PRIVATE);
        String name = preferences.getString("name","no Name");
        String Email = preferences.getString("Email","no Email");
        String Password = preferences.getString("Password","no Password");
        if(nameValue.equals(name) && EmailValue.equals(Email) && passValue.equals(Password)){
            Intent intent = new Intent(getApplicationContext(),FirstScreen.class);
            startActivity(intent);
            Toast t = Toast.makeText(this,"login successful",Toast.LENGTH_LONG);
            t.show();
        }else {
            Toast t = Toast.makeText(getApplicationContext(),Error,Toast.LENGTH_LONG);
            t.show();
        }
    }

}
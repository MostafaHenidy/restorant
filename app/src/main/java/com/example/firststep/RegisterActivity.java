package com.example.firststep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;



public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    public void insert(View v) {
        EditText editTextname = (EditText) findViewById(R.id.Fullname);
        EditText editTextemail = (EditText) findViewById(R.id.Email);
        EditText editTextpass = (EditText) findViewById(R.id.Password);
        String nameValue  = editTextname.getText().toString();
        String EmailValue  = editTextemail.getText().toString();
        String passValue  = editTextpass.getText().toString();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("SignUp_Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",nameValue);
        editor.putString("Email",EmailValue);
        editor.putString("Password",passValue);
        editor.commit();
        Intent intent = new Intent(getApplicationContext(),FirstScreen.class);
        startActivity(intent);
    }



}
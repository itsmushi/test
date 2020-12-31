package com.example.sharedinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.usernameInput);
        password=(EditText)findViewById(R.id.passwordInput);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.apply();
        Toast.makeText(getApplicationContext(),"Info saved",Toast.LENGTH_SHORT).show();

    }
    public void displayInfo(View view){
        SharedPreferences sharedPref=getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String name=sharedPref.getString("username","");
        String pw=sharedPref.getString("password","");
        username.setText(name);
        password.setText(pw);
    }
}
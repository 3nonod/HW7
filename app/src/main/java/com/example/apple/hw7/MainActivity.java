package com.example.apple.hw7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    static String user, pass;
    TextView txtV;
    TextView Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtV = (TextView) findViewById(R.id.txtvSignUp);
        txtV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(it);
                finish();
            }
        });
        Change = (TextView) findViewById(R.id.Changpass);
        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt = new Intent(getApplicationContext(), updating.class);
                startActivity(itt);
                finish();
            }
        });
    }

    public void usrLogIn(View V) {
        EditText userName = (EditText) findViewById(R.id.nameInp);
        EditText passInput = (EditText) findViewById(R.id.pwdinput);
        user = userName.getText().toString();
        pass = passInput.getText().toString();
        SharedPreferences usrAccounts = getSharedPreferences("UsersAccounts", 0);

        if (!usrAccounts.contains(user)) {
            Toast.makeText(getApplicationContext(), "The user account is not existent", Toast.LENGTH_LONG).show();
            return;
        }
        if ((usrAccounts.getString(user, null)).equals(pass)) {
            Toast.makeText(getApplicationContext(), "The access is authenticated", Toast.LENGTH_LONG).show();
            Change.setVisibility(View.VISIBLE);
        }
        else
            Toast.makeText(getApplicationContext(), "The password entered is wrong", Toast.LENGTH_LONG).show();
    }

}

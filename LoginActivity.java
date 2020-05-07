package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView attempts;
    private int count = 5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pword);
        login = (Button) findViewById(R.id.blogin);
        attempts = (TextView) findViewById(R.id.attempts);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logins(name.getText().toString(), password.getText().toString());
            }
        });
    }

    public void logins(String username, String password) {
        if ((username.equals("Admin")) && (password.equals("1111"))) {
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        } else if (username.equals("Guest")) {
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else {
            count--;
            if (count == 0) {
                attempts.setText("Too many attempts");
                login.setEnabled(false);

            }
        }
    }
}

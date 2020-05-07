package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Intent intent;
    private EditText name;
    private EditText password;
    private Button login;
    private Button create;

    AccountList acclist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pword);
        login = (Button) findViewById(R.id.blogin);
        create = (Button) findViewById(R.id.bcreate);

        acclist = AccountList.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAccount(name.getText().toString(), password.getText().toString());
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logins(name.getText().toString(), password.getText().toString());
            }
        });
    }

    public void addAccount(String username, String password) {          //uusi käyttäjä
        intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void logins(String username, String password) {              //Kirjautuminen sisään
        intent = new Intent(this, MainActivity.class);

        if (username.equals("Admin") && password.equals("1234"))  {         //Adminilla helppo salasana testauksen vuoksi
            intent.putExtra("acc", "Admin");
            startActivity(intent);
        } else if (username.equals("Guest")) {              //Guest käyttäjä ei tarvitse salasanaa
            intent.putExtra("acc", "Guest");
            startActivity(intent);
        } else {        //Luestaan listasta onko siellä peruskäyttäjäää
            for (int i =0; i<acclist.getAllUsers(); i++) {
               if (username.equals(acclist.getUser(i).getAccName()) && password.equals(acclist.getUser(i).getAccPassword())) {
                   intent.putExtra("acc", acclist.getUser(i).getAccName());    //Tungetaan käyttäjänimi mukaan
                   System.out.println("meneekö3");
                   startActivity(intent);
               }
            }
        }
    }
}

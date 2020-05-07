package com.example.ht;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccount extends Activity {
    private EditText username;
    private EditText password;
    private Button button;
    private TextView check;
    private int b = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        username = (EditText) findViewById(R.id.cuname);
        password = (EditText) findViewById(R.id.cpword);
        check = (TextView) findViewById(R.id.checker);
        button = (Button) findViewById(R.id.cbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAcc(username.getText().toString(), password.getText().toString());
            }
        });
    }
    public void CreateAcc(String name, String passw) {
        //Onko iso alkukirjan tekstissä
        for(int i=passw.length()-1; i>=0; i--) {
            if(Character.isUpperCase(passw.charAt(i))) {
                b++;
            }
        }       //Tarkistetaan onko salasana ns. hyvä salasana
        //https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
        if (b>0 && passw.length()>=12) {
            Pattern l = Pattern.compile("[a-zA-z]");
            Pattern d = Pattern.compile("[0-9]");
            Pattern s = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = l.matcher(passw);
            Matcher hasDigit = d.matcher(passw);
            Matcher hasSpecial = s.matcher(passw);

            if (hasLetter.find() && hasDigit.find() && hasSpecial.find() ==  true) {
                AccountList.getInstance().CreateAc(name, passw, "","");
            }
            System.out.println("Created new account: "+ name+" "+passw);
            finish();

        } else {
            check.setText("Your password must contain " +
                    "at least one uppercase letter, a number," +
                    " 12 characters and a special character!");
        }

    }
}

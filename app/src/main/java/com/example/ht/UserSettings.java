package com.example.ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.ht.MainActivity.user;

public class UserSettings extends AppCompatActivity {
    EditText settingsName;
    EditText settingsPassword;
    EditText settingsEmail;
    EditText settingPhone;
    Button settingsButton;
    AccountList acclist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        settingsName = (EditText) findViewById(R.id.setname);
        settingsPassword = (EditText) findViewById(R.id.setpassword);
        settingsEmail = (EditText) findViewById(R.id.email);
        settingPhone = (EditText) findViewById(R.id.phone);
        settingsButton = (Button) findViewById(R.id.baccept);

        acclist = AccountList.getInstance();
        settingsName.setText(user.username);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeSettings(settingsName.getText().toString(),settingsPassword.getText().toString(),
                        settingsEmail.getText().toString(),settingPhone.getText().toString());
            }
        });
    }
    public void ChangeSettings (String name, String password, String email, String phone) {
        for(int i = 0; i<acclist.getAllUsers(); i++) {
            if (user.username.equals(acclist.getUser(i).getAccName())) {
                UserSave us = AccountList.getInstance().getUser(i);
                us.setAccName(name);                                    //Uudet käyttäjätiedot
                us.setAccPassword(password);                            //Ei huomioi salasanan hyvyyttä
                us.setAccEmail(email);
                us.setAccPhone(phone);
                acclist.printAccounts();
                finish();
            }
        }

    }
}

package com.manrique.daniel.smiteapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {

    Button createBtn;
    TextView usernameTxt, emailTxt, passwordTxt, titleTxt;
    String username, email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.create_account);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        createBtn = (Button) findViewById(R.id.create_btn);
        usernameTxt = (TextView) findViewById(R.id.new_username_txt);
        emailTxt = (TextView) findViewById(R.id.new_email_txt);
        passwordTxt = (TextView) findViewById(R.id.new_password_txt);

        createBtn.setFocusable(true);
        createBtn.setFocusableInTouchMode(true);
        createBtn.requestFocus();

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = String.valueOf(usernameTxt.getText());
                email = String.valueOf(emailTxt.getText());
                password = String.valueOf(passwordTxt.getText());
                create(username, email, password);
            }
        });

    }

    private void create(String username, String email, String password) {
        if (validate()) {
            Intent toMainMenu = new Intent().setClass(CreateAccount.this, MainMenu.class);
            startActivity(toMainMenu);
        }
    }

    private boolean validate() {

        if (username.isEmpty() || username.length() < 4 || username.length() > 16) {
            usernameTxt.setError(getString(R.string.username_length));
            return false;
        } else if (username.matches("\\w")) {
            usernameTxt.setError(getString(R.string.valid_characters));
            return false;

        } else if (email.isEmpty()) {
            emailTxt.setError(getString(R.string.email_length));
            return false;

        } else if (password.isEmpty() || password.length() < 4 || password.length() > 16) {
            passwordTxt.setError(getString(R.string.password_length));
            return false;

        } else if (password.matches("\\w")) {
            passwordTxt.setError(getString(R.string.valid_characters));
            return false;
        }

        return true;

    }
}

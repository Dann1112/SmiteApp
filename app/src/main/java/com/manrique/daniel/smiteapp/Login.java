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
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button signInBtn;
    Button signUpBtn;
    TextView usernameTxt;
    TextView passwordTxt;
    String username;
    String pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.login);

        signInBtn = (Button) findViewById(R.id.sign_in_btn);
        signUpBtn = (Button) findViewById(R.id.sign_up_btn);
        usernameTxt = (TextView) findViewById(R.id.username_txt);
        passwordTxt = (TextView) findViewById(R.id.password_txt);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "CLICK", Toast.LENGTH_SHORT).show();

                login();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent().setClass(Login.this, CreateAccount.class));
            }
        });

    }


    private void login() {
        if (validate()) {

            Toast.makeText(this, "Autenticado", Toast.LENGTH_SHORT).show();
            //Intent toMainMenu = new Intent().setClass(Login.this, MainMenu.class);
            //startActivity(toMainMenu);
        } else
            Toast.makeText(this, "FAIL", Toast.LENGTH_SHORT).show();
    }

    private boolean validate() {

        username = String.valueOf(usernameTxt.getText());
        pass = String.valueOf(passwordTxt.getText());

        if (username.isEmpty() || username.length() < 4 || username.length() > 16) {
            usernameTxt.setError(getString(R.string.username_length));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;
        } else if (username.matches("/W")) {
            usernameTxt.setError(getString(R.string.valid_characters));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;
        } else if (pass.isEmpty() || pass.length() < 4 || pass.length() > 16) {
            passwordTxt.setError(getString(R.string.password_length));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;

        } else if (pass.matches("/W")) {
            passwordTxt.setError(getString(R.string.valid_characters));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;
        }

        return true;

    }
}

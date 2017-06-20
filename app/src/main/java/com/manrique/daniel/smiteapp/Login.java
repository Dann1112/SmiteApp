package com.manrique.daniel.smiteapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button signInBtn;
    Button signUpBtn;
    TextView usernameTxt;
    ImageView logoImg;
    TextView passwordTxt;
    String username;
    String pass;
    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            username = String.valueOf(usernameTxt.getText());
            pass = String.valueOf(passwordTxt.getText());
            login(username, pass);
        }
    };
    private View.OnClickListener createAccountListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent toCreateAccount = new Intent().setClass(Login.this, CreateAccount.class);
            startActivity(toCreateAccount);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.login);

        logoImg = (ImageView) findViewById(R.id.logo_img);
        signInBtn = (Button) findViewById(R.id.sign_in_btn);
        signUpBtn = (Button) findViewById(R.id.sign_up_btn);
        usernameTxt = (TextView) findViewById(R.id.username_txt);
        passwordTxt = (TextView) findViewById(R.id.password_txt);

        signInBtn.setOnClickListener(loginListener);

        signUpBtn.setOnClickListener(createAccountListener);

        logoImg.setFocusable(true);
        logoImg.setFocusableInTouchMode(true);
        logoImg.requestFocus();


    }

    private void login(String username, String password) {

        if (validate()) {

            //TODO Connection to DB to login user
            Intent toMainMenu = new Intent().setClass(Login.this, NavigationDrawer.class);
            startActivity(toMainMenu);
        }
    }

    private boolean validate() {

        if (username.isEmpty() || username.length() < 4 || username.length() > 16) {
            usernameTxt.setError(getString(R.string.username_length));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;

        } else if (username.matches("\\w")) {
            usernameTxt.setError(getString(R.string.valid_characters));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;

        } else if (pass.isEmpty() || pass.length() < 4 || pass.length() > 16) {
            passwordTxt.setError(getString(R.string.password_length));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;

        } else if (pass.matches("\\w")) {
            passwordTxt.setError(getString(R.string.valid_characters));
            usernameTxt.setText("");
            passwordTxt.setText("");
            return false;
        }

        return true;

    }
}

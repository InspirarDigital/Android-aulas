package com.atilabraga.aula1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_NAME = "aula1";
    public static final String KEY_USER = "user";

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String user = getLocalUser();
        if (!TextUtils.isEmpty(user)) {
            openSecondActivity(user);
        }

        setContentView(R.layout.activity_main);
        setViews();

        btnLogin.setOnClickListener(this);
    }

    private void setViews() {
        etUser = (EditText) findViewById(R.id.main_et_user);
        etPassword = (EditText) findViewById(R.id.main_et_password);
        btnLogin = (Button) findViewById(R.id.main_btn_login);
    }

    private void saveLocalUser(String user) {
        SharedPreferences prefs =
                getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(KEY_USER, user);
        editor.commit();
    }

    private String getLocalUser() {
        SharedPreferences prefs =
                getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        return prefs.getString(KEY_USER, "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_login:
                String user = etUser.getText().toString();
                String password = etPassword.getText().toString();
                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)) {
                    saveLocalUser(user);
                    openSecondActivity(user);
                }
                break;
        }
    }

    private void openSecondActivity(String user) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }
}

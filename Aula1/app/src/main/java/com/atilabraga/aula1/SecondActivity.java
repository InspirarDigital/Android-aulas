package com.atilabraga.aula1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((TextView) findViewById(R.id.second_lbl_welcome))
                .setText("Bem vindo, " + getIntent().getStringExtra("user"));
    }

    private void removeLocalUser() {
        SharedPreferences.Editor editor =
                getSharedPreferences(MainActivity.PREFS_NAME,
                        MODE_PRIVATE).edit();
        editor.putString(MainActivity.KEY_USER, "").commit();
    }

    public void onLogoutClick(View view) {
        removeLocalUser();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
;    }

}

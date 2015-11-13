package com.atilabraga.aula4.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atilabraga.aula4.R;
import com.atilabraga.aula4.model.Task;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TASK = "extra_task";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Task task = getIntent().getParcelableExtra(EXTRA_TASK);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_container, DetailShowFragment.getInstance(task))
                .commit();
    }
}

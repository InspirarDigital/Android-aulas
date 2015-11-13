package com.atilabraga.aula4.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.atilabraga.aula4.R;
import com.atilabraga.aula4.dao.TaskDao;
import com.atilabraga.aula4.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvTask;
    private List<Task> taskList = new ArrayList<>();

    private TaskDao daoTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

        daoTask = new TaskDao(this);
        taskList = daoTask.getAll();

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        lvTask.setAdapter(adapter);
    }

    private void setViews() {
        lvTask = (ListView) findViewById(R.id.main_list_view);
    }
}

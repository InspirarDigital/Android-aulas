package com.atilabraga.aula2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.atilabraga.aula2.R;
import com.atilabraga.aula2.adapter.ListAdapter;

/**
 * Created by atilabraga on 9/26/15.
 */
public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setViews();
        mRecyclerView.setAdapter(
                new ListAdapter(this, new String[]{
                        "Item 1", "Item 2", "Item 3",
                        "Item 4", "Item 5", "Item 6",
                        "Item 7", "Item 8", "Item 9",
                        "Item 10", "Item 11", "Item 12",
                        "Item 13", "Item 14", "Item 15",
                        "Item 16", "Item 17", "Item 18"
                }));
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this));
    }

    private void setViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
    }

}

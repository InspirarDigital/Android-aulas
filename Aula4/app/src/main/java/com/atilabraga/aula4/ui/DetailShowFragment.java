package com.atilabraga.aula4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atilabraga.aula4.R;
import com.atilabraga.aula4.model.Task;

/**
 * Created by atilabraga on 10/17/15.
 */
public class DetailShowFragment extends Fragment {

    private static final String EXTRA_TASK = "extra_task";

    public DetailShowFragment() {
    }

    public static DetailShowFragment getInstance(Task task) {
        DetailShowFragment fragment = new DetailShowFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_TASK, task);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_show, container, false);
        return view;
    }
}

package com.atilabraga.aula2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atilabraga.aula2.R;

/**
 * Created by atilabraga on 9/26/15.
 */
public class PagesFragment extends Fragment {

    public static Fragment getInstance(int page) {
        Fragment fragment = new PagesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page", page);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pages,
                container, false);
        ((TextView) view.findViewById(R.id.pages_num))
                .setText(String.valueOf(getArguments()
                        .getInt("page")));
        return view;
    }
}

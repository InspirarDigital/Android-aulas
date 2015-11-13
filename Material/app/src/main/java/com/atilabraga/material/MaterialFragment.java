package com.atilabraga.material;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by atilabraga on 10/31/15.
 */
public class MaterialFragment extends Fragment {

    private static final String TAB_POSITION = "tab_position";

    public MaterialFragment() {
    }

    public static MaterialFragment newInstance(String tab) {
        MaterialFragment fragment = new MaterialFragment();
        Bundle args = new Bundle();
        args.putString(TAB_POSITION, tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        textView.setText("Tab selected :  #"
                + getArguments().getString(TAB_POSITION));
        return textView;
    }
}

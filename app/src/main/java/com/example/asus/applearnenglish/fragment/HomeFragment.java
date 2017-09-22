package com.example.asus.applearnenglish.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.applearnenglish.R;

/**
 * Created by Asus on 9/22/2017.
 */

public class HomeFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void init() {

    }

    private void event() {

    }
}

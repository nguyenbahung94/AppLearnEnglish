package com.example.asus.applearnenglish.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.applearnenglish.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Asus on 9/22/2017.
 */

public class HomeFragment extends Fragment {
    private View view;
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        event();
        return view;
    }

    private void init() {
        databaseReference = FirebaseDatabase.getInstance().getReference();

    }

    private void event() {

    }
}

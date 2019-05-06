package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.R;

public class Fragment_Trang_Chu extends Fragment {

    View view;

    //onCreateView: gan Layout cho Fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Gan layout
        view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        return view;
    }
}

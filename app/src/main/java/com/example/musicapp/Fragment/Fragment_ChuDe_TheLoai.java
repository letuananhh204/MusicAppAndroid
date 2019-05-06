package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.musicapp.R;
import com.example.musicapp.Service.APIService;
import com.example.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai extends Fragment {

    View view;
    HorizontalScrollView hsvScrollView;
    TextView txtMoreViewChuDeTheLoai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmen_chude_theloai, container, false);
        hsvScrollView = view.findViewById(R.id.hsvSrollView);
        txtMoreViewChuDeTheLoai = view.findViewById(R.id.txtMoreViewChuDeTheLoai);
        getData();
        return view;
    }

    private void getData() {

    }
}

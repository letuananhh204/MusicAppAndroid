package com.example.musicapp.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.musicapp.Adapter.DanhSachPlaylistAdapter;
import com.example.musicapp.Model.Playlist;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIService;
import com.example.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachPlayListActivity extends AppCompatActivity {

    Toolbar tbDanhSachPlaylist;
    RecyclerView rcvDanhSachPlaylist;
    ArrayList<Playlist> mangPlayList;
    DanhSachPlaylistAdapter danhSachPlaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_play_list);
        anhxa();
        init();
        getData();
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callBack = dataservice.getDanhSachPlaylist();
        callBack.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                mangPlayList = (ArrayList<Playlist>) response.body();
                danhSachPlaylistAdapter = new DanhSachPlaylistAdapter(DanhSachPlayListActivity.this, mangPlayList);
                rcvDanhSachPlaylist.setLayoutManager(new GridLayoutManager(DanhSachPlayListActivity.this, 2));
                rcvDanhSachPlaylist.setAdapter(danhSachPlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(tbDanhSachPlaylist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play List");
        tbDanhSachPlaylist.setTitleTextColor(Color.GREEN);
        tbDanhSachPlaylist.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        tbDanhSachPlaylist = findViewById(R.id.tbDanhSachPlaylist);
        rcvDanhSachPlaylist = findViewById(R.id.rcvDanhSachPlaylist);
    }
}

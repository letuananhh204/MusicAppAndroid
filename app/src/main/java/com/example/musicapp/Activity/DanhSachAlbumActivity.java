package com.example.musicapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.musicapp.Adapter.AllAlbumAdapter;
import com.example.musicapp.Model.Album;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIService;
import com.example.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachAlbumActivity extends AppCompatActivity {

    Toolbar tbDSAlbum;
    RecyclerView rcvDSAlbum;
    ArrayList<Album> mangAlbum;
    AllAlbumAdapter allAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_album);
        init();
        getData();
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.getDanhSachAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mangAlbum = (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(DanhSachAlbumActivity.this, mangAlbum);
                rcvDSAlbum.setLayoutManager(new GridLayoutManager(DanhSachAlbumActivity.this, 2));
                rcvDSAlbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        tbDSAlbum = findViewById(R.id.tbDSAlbum);
        rcvDSAlbum = findViewById(R.id.rcvDSAlbum);
        setSupportActionBar(tbDSAlbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Album");
        tbDSAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

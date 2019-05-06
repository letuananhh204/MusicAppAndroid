package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicapp.Activity.PlayMusicActivity;
import com.example.musicapp.Adapter.PlayMusicAdapter;
import com.example.musicapp.R;

public class Fragment_Play_Music extends Fragment {

    View view;
    RecyclerView rcvPlayMusic;
    PlayMusicAdapter playMusicAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmen_playmusic, container, false);
        rcvPlayMusic = view.findViewById(R.id.rcvPlayMusic);
        if(PlayMusicActivity.mangBaiHat.size() > 0) {
            playMusicAdapter = new PlayMusicAdapter(getActivity(), PlayMusicActivity.mangBaiHat);
            rcvPlayMusic.setLayoutManager(new LinearLayoutManager(getActivity()));
            rcvPlayMusic.setAdapter(playMusicAdapter);
        }

        return view;
    }
}

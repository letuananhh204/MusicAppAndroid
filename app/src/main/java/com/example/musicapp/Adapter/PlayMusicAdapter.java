package com.example.musicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.musicapp.Model.BaiHat;
import com.example.musicapp.R;

import java.util.ArrayList;

public class PlayMusicAdapter extends RecyclerView.Adapter<PlayMusicAdapter.ViewHolder>{

    Context context;
    ArrayList<BaiHat> mangBaiHat;

    public PlayMusicAdapter(Context context, ArrayList<BaiHat> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_playmusic, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BaiHat baiHat = mangBaiHat.get(i);
        viewHolder.txtPlayMuiscTenCaSy.setText(baiHat.getTenCaSy());
        viewHolder.txtPlayMusicIndex.setText(i + 1 + "");
        viewHolder.txtPlayMuiscTenBaiHat.setText(baiHat.getTenBaiHat());
    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPlayMusicIndex, txtPlayMuiscTenBaiHat, txtPlayMuiscTenCaSy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPlayMuiscTenCaSy = itemView.findViewById(R.id.txtPlayMuiscTenCaSy);
            txtPlayMuiscTenBaiHat = itemView.findViewById(R.id.txtPlayMuiscTenBaiHat);
            txtPlayMusicIndex = itemView.findViewById(R.id.txtPlayMusicIndex);
        }
    }
}

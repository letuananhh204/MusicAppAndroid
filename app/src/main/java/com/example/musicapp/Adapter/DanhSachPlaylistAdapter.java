package com.example.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.Playlist;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachPlaylistAdapter extends  RecyclerView.Adapter<DanhSachPlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<Playlist> mangPlaylist;

    public DanhSachPlaylistAdapter(Context context, ArrayList<Playlist> mangPlaylist) {
        this.context = context;
        this.mangPlaylist = mangPlaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachplaylist, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Playlist playlist = mangPlaylist.get(i);
        Picasso.with(context).load(playlist.getHinhPlayList()).into(viewHolder.imgDanhSachPlaylist);
        viewHolder.txtDanhsachPlaylist.setText(playlist.getTen());

    }

    @Override
    public int getItemCount() {
        return mangPlaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgDanhSachPlaylist;
        TextView txtDanhsachPlaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDanhSachPlaylist = itemView.findViewById(R.id.imgDanhSachPlaylist);
            txtDanhsachPlaylist = itemView.findViewById(R.id.txtDanhsachPlaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist", mangPlaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}

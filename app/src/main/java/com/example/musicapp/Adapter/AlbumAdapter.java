package com.example.musicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.Model.Album;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Album album = mangalbum.get(i);
        viewHolder.txtTenCaSyAlbum.setText(album.getTenCaSy());
        viewHolder.txtTenAlbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(viewHolder.imgHinhAlbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgHinhAlbum;
        TextView txtTenAlbum, txtTenCaSyAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhAlbum = itemView.findViewById(R.id.imgAlbum);
            txtTenAlbum = itemView.findViewById(R.id.txtTenAlbum);
            txtTenCaSyAlbum = itemView.findViewById(R.id.txtTenCaSyAlbum);
        }
    }
}

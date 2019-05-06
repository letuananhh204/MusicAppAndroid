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

public class AllAlbumAdapter extends  RecyclerView.Adapter<AllAlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> albumArrayList;

    public AllAlbumAdapter(Context context, ArrayList<Album> mangAlbum) {
        this.context = context;
        this.albumArrayList = mangAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_allalbum, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Album album = albumArrayList.get(i);
        Picasso.with(context).load(album.getHinhAlbum()).into(viewHolder.imgDanhSachAlbum);
        viewHolder.txtDanhsachAlbum.setText(album.getTenAlbum());
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgDanhSachAlbum;
        TextView txtDanhsachAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDanhSachAlbum = itemView.findViewById(R.id.imgDanhSachAlbum);
            txtDanhsachAlbum = itemView.findViewById(R.id.txtDanhsachAlbum);
        }
    }
}

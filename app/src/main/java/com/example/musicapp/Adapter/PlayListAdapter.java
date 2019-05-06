package com.example.musicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.Model.Playlist;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListAdapter extends ArrayAdapter<Playlist> {
    public PlayListAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView txtTenPlayList;
        ImageView imgBackgroundPlayList, imgPlayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.txtTenPlayList  = convertView.findViewById(R.id.txtTenPlayList);
            viewHolder.imgPlayList = convertView.findViewById(R.id.imgPlaylist);
            viewHolder.imgBackgroundPlayList = convertView.findViewById(R.id.imgBackgroundPlayList);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlayList()).into(viewHolder.imgBackgroundPlayList);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewHolder.imgPlayList);
        viewHolder.txtTenPlayList.setText(playlist.getTen());
        return convertView;
    }
}

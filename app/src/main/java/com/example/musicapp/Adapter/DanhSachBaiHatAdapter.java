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
import android.widget.Toast;

import com.example.musicapp.Activity.PlayMusicActivity;
import com.example.musicapp.Model.BaiHat;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIService;
import com.example.musicapp.Service.Dataservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatAdapter extends  RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHoler>{

    Context context;
    ArrayList<BaiHat> mangBaiHat;

    public DanhSachBaiHatAdapter(Context context, ArrayList<BaiHat> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachbaihat, viewGroup, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {
        BaiHat baiHat = mangBaiHat.get(i);
        viewHoler.txtTenCaSy.setText(baiHat.getTenCaSy());
        viewHoler.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        viewHoler.txtDanhSachIndex.setText(i + 1 + "");

    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        TextView txtDanhSachIndex, txtTenBaiHat, txtTenCaSy;
        ImageView imgLuotLike;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtTenCaSy = itemView.findViewById(R.id.txtTenCaSy);
            txtTenBaiHat = itemView.findViewById(R.id.txtTenBaiHat);
            txtDanhSachIndex = itemView.findViewById(R.id.txtDanhSachIndex);
            imgLuotLike = itemView.findViewById(R.id.imgluotLike);
            imgLuotLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLuotLike.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.updateLike("1", mangBaiHat.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String kq = response.body();
                            if(kq.equals("OK")) {
                                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "False", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgLuotLike.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("cakhuc", mangBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}

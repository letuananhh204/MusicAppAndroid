package com.example.musicapp.Service;

import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.BaiHat;
import com.example.musicapp.Model.Playlist;
import com.example.musicapp.Model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<QuangCao>> getDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> getPlayListCurrentDay();

    @GET("album.php")
    Call<List<Album>> getAlbumHot();

    @GET("luotthich.php")
    Call<List<BaiHat>> getBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>>  getDanhSachBaiHatTheoQC(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoPlaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Playlist>> getDanhSachPlaylist();

    @GET("danhsachalbum.php")
    Call<List<Album>> getDanhSachAlbum();

    @FormUrlEncoded
    @POST("updateLike.php")
    Call<String> updateLike(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);
}

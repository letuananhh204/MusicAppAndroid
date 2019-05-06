package com.example.musicapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("idAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("tenAlbum")
    @Expose
    private String tenAlbum;
    @SerializedName("tenCaSy")
    @Expose
    private String tenCaSy;
    @SerializedName("hinhAlbum")
    @Expose
    private String hinhAlbum;

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    public String getTenCaSy() {
        return tenCaSy;
    }

    public void setTenCaSy(String tenCaSy) {
        this.tenCaSy = tenCaSy;
    }

    public String getHinhAlbum() {
        return hinhAlbum;
    }

    public void setHinhAlbum(String hinhAlbum) {
        this.hinhAlbum = hinhAlbum;
    }

}
package com.example.musicapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe {

@SerializedName("idTheLoai")
@Expose
private String idTheLoai;
@SerializedName("idChuDe")
@Expose
private String idChuDe;
@SerializedName("tenTheLoai")
@Expose
private String tenTheLoai;
@SerializedName("hinhTheLoai")
@Expose
private String hinhTheLoai;
@SerializedName("tenChuDe")
@Expose
private String tenChuDe;
@SerializedName("hinhChuDe")
@Expose
private String hinhChuDe;

public String getIdTheLoai() {
return idTheLoai;
}

public void setIdTheLoai(String idTheLoai) {
this.idTheLoai = idTheLoai;
}

public String getIdChuDe() {
return idChuDe;
}

public void setIdChuDe(String idChuDe) {
this.idChuDe = idChuDe;
}

public String getTenTheLoai() {
return tenTheLoai;
}

public void setTenTheLoai(String tenTheLoai) {
this.tenTheLoai = tenTheLoai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

public String getTenChuDe() {
return tenChuDe;
}

public void setTenChuDe(String tenChuDe) {
this.tenChuDe = tenChuDe;
}

public String getHinhChuDe() {
return hinhChuDe;
}

public void setHinhChuDe(String hinhChuDe) {
this.hinhChuDe = hinhChuDe;
}

}
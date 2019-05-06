package com.example.musicapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TheLoai {

@SerializedName("TheLoai")
@Expose
private List<Object> theLoai = null;
@SerializedName("ChuDe")
@Expose
private List<ChuDe> chuDe = null;

public List<Object> getTheLoai() {
return theLoai;
}

public void setTheLoai(List<Object> theLoai) {
this.theLoai = theLoai;
}

public List<ChuDe> getChuDe() {
return chuDe;
}

public void setChuDe(List<ChuDe> chuDe) {
this.chuDe = chuDe;
}

}
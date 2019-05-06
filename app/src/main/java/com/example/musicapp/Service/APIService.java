package com.example.musicapp.Service;

public class APIService {

    private static  String base_url = "https://musicandroide15cn1.000webhostapp.com/Server/";
    public static Dataservice getService() {
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}

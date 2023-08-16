package com.example.hoanchinh.Service_API;

public class APIService {

    public static Dataservice getService(){
        String base_url = "https://thienmache.000webhostapp.com/Server/";
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}

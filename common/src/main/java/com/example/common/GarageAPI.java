package com.example.common;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GarageAPI {

    @GET()
    Call<Garage> loadGarage();


}

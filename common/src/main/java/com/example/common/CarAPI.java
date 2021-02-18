package com.example.common;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarAPI {

    @GET()
    Call<List<Car>> loadCars();


}

package com.example.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarController {

    static final String API_BASE_URL = "https://pastebin.com/raw/WypPzJCt/";
    static List<Car> carsList;

    private CallBack_Car callBack_car;
    private CallBack_Cars callBack_cars;

    Callback<List<Car>> carsArrayCallBack = new Callback<List<Car>>() {

        @Override
        public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
            if (response.isSuccessful()) {
                //            carsList = response.body();
                List<Car> cars = response.body();

                if (callBack_cars != null) {
                    callBack_cars.cars(cars);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<List<Car>> call, Throwable t) {
            t.printStackTrace();
        }

    };
    Callback<Car> carCallBack = new Callback<Car>() {
        @Override
        public void onResponse(Call<Car> call, Response<Car> response) {
            if (response.isSuccessful()) {
                Car car = response.body();
                if (callBack_car != null) {
                    callBack_car.car(car);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<Car> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public void fetchAllCars(CallBack_Cars callBack_cars) {
        this.callBack_cars = callBack_cars;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CarAPI carAPI = retrofit.create(CarAPI.class);

        Call<List<Car>> call = carAPI.loadCars();
        call.enqueue(carsArrayCallBack);
    }

    public interface CallBack_Cars {
        void cars(List<Car> cars);
    }

    public interface CallBack_Car {
        void car(Car car);
    }
}

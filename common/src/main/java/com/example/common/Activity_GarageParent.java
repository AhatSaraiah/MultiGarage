package com.example.common;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;

import java.util.List;

public abstract class Activity_GarageParent extends AppCompatActivity {
    private TextView map_LBL_title;
    private MaterialButton main_BTN_downloadGarage;
    private MaterialTextView main_LBL_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentgarage);
        new Gson();
        main_BTN_downloadGarage = findViewById(R.id.main_BTN_downloadGarage);
        map_LBL_title = findViewById(R.id.map_LBL_title);
        main_LBL_info = findViewById(R.id.main_LBL_info);


        main_BTN_downloadGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadGarage();
                downloadCars();
            }
        });
    }

    protected void setTitle(String title) {
        map_LBL_title.setText(title);
    }


    private void downloadCars() {
        new CarController().fetchAllCars(new CarController.CallBack_Cars() {
            @Override
            public void cars(List<Car> cars) {
                main_LBL_info.setText(cars.toString());
            }
        });
    }

    private void downloadGarage() {
        new GarageController().fetchGarage(new GarageController.CallBack_Garage() {
            @Override
            public void garage(Garage garage) {
                setTitle(garage.toString());
            }
        });
    }

}

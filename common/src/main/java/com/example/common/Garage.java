package com.example.common;

import java.util.ArrayList;

public class Garage {

    private ArrayList <Car> Cars=new ArrayList<Car>();
    private Boolean open ;
    private String address;
    private String name ;


    public Garage() { }

    public String getName() {
        return name;
    }

    public ArrayList<Car> getCars() {
        return Cars;
    }

    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "Cars=" + Cars +
                ", open=" + open +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

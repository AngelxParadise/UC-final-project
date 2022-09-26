package com.example.foodtrucks;

import java.io.Serializable;

public class cuisines implements Serializable {
    private String CuisineType;
    private String CuisineImg;

    public cuisines() {
    }

    public cuisines(String cuisineType, String cuisineImg) {
        CuisineType = cuisineType;
        CuisineImg = cuisineImg;
    }

    public String getCuisineType() {
        return CuisineType;
    }

    public void setCuisineType(String cuisineType) {
        CuisineType = cuisineType;
    }

    public String getCuisineImg() {
        return CuisineImg;
    }

    public void setCuisineImg(String cuisineImg) {
        CuisineImg = cuisineImg;
    }
}

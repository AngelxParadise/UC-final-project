package com.example.foodtrucks;

import java.io.Serializable;

public class foodtrucks implements Serializable {
    private String foodtruckName;
    private String foodtruckInstagram;
    private String foodtruckLocation;
    private String foodtruckImg;
    private String truckcuisinetype;

    public foodtrucks() {
    }

    public foodtrucks(String foodtruckName, String foodtruckInstagram, String foodtruckLocation, String foodtruckImg, String truckcuisinetype) {
        this.foodtruckName = foodtruckName;
        this.foodtruckInstagram = foodtruckInstagram;
        this.foodtruckLocation = foodtruckLocation;
        this.foodtruckImg = foodtruckImg;
        this.truckcuisinetype = truckcuisinetype;
    }

    public String getFoodtruckName() {
        return foodtruckName;
    }

    public void setFoodtruckName(String foodtruckName) {
        this.foodtruckName = foodtruckName;
    }

    public String getFoodtruckInstagram() {
        return foodtruckInstagram;
    }

    public void setFoodtruckInstagram(String foodtruckInstagram) {
        this.foodtruckInstagram = foodtruckInstagram;
    }

    public String getFoodtruckLocation() {
        return foodtruckLocation;
    }

    public void setFoodtruckLocation(String foodtruckLocation) {
        this.foodtruckLocation = foodtruckLocation;
    }

    public String getFoodtruckImg() {
        return foodtruckImg;
    }

    public void setFoodtruckImg(String foodtruckImg) {
        this.foodtruckImg = foodtruckImg;
    }

    public String getTruckcuisinetype() {
        return truckcuisinetype;
    }

    public void setTruckcuisinetype(String truckcuisinetype) {
        this.truckcuisinetype = truckcuisinetype;
    }
}
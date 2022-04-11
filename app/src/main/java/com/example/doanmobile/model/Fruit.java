package com.example.doanmobile.model;

//
public class Fruit {
    private String fruitImg;
    private String fruitName;
    private String calories;
    public Fruit(String fruitImg, String fruitName, String calories) {
        this.fruitImg = fruitImg;
        this.fruitName = fruitName;
        this.calories = calories;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFruitImg() {
        return fruitImg;
    }

    public void setFruitImg(String fruitImg) {
        this.fruitImg = fruitImg;
    }

}
//

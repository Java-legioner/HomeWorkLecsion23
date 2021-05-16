package com.example;

public class Human {

    private int weight;
    private int height;

    public Human(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public Human(){

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return
                ", weight=" + weight +
                        ", height=" + height +
                        '}';
    }
}


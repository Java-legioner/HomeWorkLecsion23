package com.example;

import java.util.Random;

public class Deputies extends Human {

    private String lastName;
    private String name;
    private int age;
    private boolean grafter;
    private int sizeOfBribe;

    public Deputies(int weight, int height, String lastName, String name, int age, boolean grafter) {
        super(weight, height);
        this.lastName = lastName;
        this.name = name;
        this.age = age;
        this.grafter = grafter;
    }


    public Deputies(){

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGrafter() {
        return grafter;
    }

    public void setGrafter(boolean grafter) {
        this.grafter = grafter;
    }

    public int getSizeOfBribe() {
        return sizeOfBribe;
    }

    public void setSizeOfBribe(int sizeOfBribe) {
        this.sizeOfBribe = sizeOfBribe;
    }

    public void giveBribe(int val){
        if(!grafter){
            System.out.println("Цей депутат не бере хабарів");
        } else {
            System.out.println("Сумма хабаря" + val);
            if (val > 5000) {
                sizeOfBribe = val;
                System.out.println("Поліція ув'язнить депутата");
            }else {
                sizeOfBribe = val;
            }
        }
    }


    @Override
    public String toString() {
        return "Deputies{" +
                "LastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grafter=" + grafter +
                ", sizeOfBribe=" + sizeOfBribe
                + super.toString();
    }
}


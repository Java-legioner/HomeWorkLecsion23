package com.example.task2_14;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {

        Scanner sc = new Scanner(System.in);
        CommodityMethods commodity = new CommodityMethods();

        boolean exit = false;
        while (!exit){
            commodity.menu();

            switch (sc.next()){
                case "1": {
                    commodity.addCommodity();
                }
                break;

                case "2": {
                    commodity.removeCommodity();
                }
                break;

                case "3": {
                    commodity.replaceCommodity();
                }
                break;

                case "4": {
                    commodity.sortingByName();
                }
                break;

                case "5": {
                    commodity.sortingByLength();
                }
                break;

                case "6": {
                    commodity.sortingByWidth();
                }
                break;

                case "7": {
                    commodity.sortingByWeight();
                }
                break;

                case "8": {
                    commodity.displayCommodity();
                }
                break;

                case "9": {
                    exit = true;
                }
                break;
            }
        }


    }
}


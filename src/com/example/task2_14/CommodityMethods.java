package com.example.task2_14;


import com.example.Deputies;
import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommodityMethods {

    Scanner sc = new Scanner(System.in);
    List<Commodity> commodityList = new ArrayList<>();

    public void menu() {
        System.out.println("Натисніть 1, щоб додати новий товар");
        System.out.println("Натисніть 2, щоб видалити товар");
        System.out.println("Натисніть 3, щоб замінити товар");
        System.out.println("Натисніть 4, щоб відсортувати за назвою");
        System.out.println("Натисніть 5, щоб відсортувати за довжиною");
        System.out.println("Натисніть 6, щоб відсортувати за шириною");
        System.out.println("Натисніть 7, щоб відсортувати за вагою");
        System.out.println("Натисніть 8, щоб вивести елемент");
        System.out.println("Натисніть 9, щоб вийти з програми");
    }

    Supplier<Commodity> commoditySupplier = () -> {
        System.out.println("Введіть назву товара");
        String name = sc.next();

        boolean flag = false;

        for (Commodity com : commodityList) {
            if (com.name.equals(name)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Товар з такою назвою існує");
        }
        if (!flag) {
            try {
                Commodity com = new Commodity(name, getRandomInt(10, 100), getRandomInt(5, 50), getRandomInt(1, 50));
                commodityList.add(com);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return new Commodity();
    };

    public void addCommodity() throws IllegalAccessException {
        Commodity commodity = commoditySupplier.get();
        System.out.println(commodityList);
    }

    public void removeCommodity() {
        System.out.println("Введіть назву товара");
        String name = sc.next();

        Commodity commodity = commodityList
                .stream()
                .filter(e -> e.name.equalsIgnoreCase(name))
                .findFirst()
                .get();
        commodityList.remove(commodity);

        System.out.println(commodityList);

    }

    public void replaceCommodity() throws IllegalAccessException {
        System.out.println("Введіть назву товари який хочете замінити");
        String name1 = sc.next();
        System.out.println("Введіть назву нового товару");
        String name2 = sc.next();

        Commodity commodity = commodityList
                .stream()
                .filter(e -> e.name.equalsIgnoreCase(name1))
                .findFirst()
                .get();
        commodityList.remove(commodity);

        Commodity commodity1 = new Commodity(name2, getRandomInt(10, 100), getRandomInt(5, 50), getRandomInt(1, 50));
        commodityList.add(commodity1);

        System.out.println(commodityList);
    }

    public void sortingByName() {


        Collections.sort(commodityList, new CommodityNameComparator());

        for (Commodity com : commodityList) {
            System.out.println(com);
        }
    }

    public void sortingByLength() {
        List<Commodity> collect = commodityList.stream()
                .sorted(Comparator.comparing(Commodity::getLength))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public void sortingByWidth() {
        List<Commodity> collect = commodityList.stream()
                .sorted(Comparator.comparing(Commodity::getWidth))
                .collect(Collectors.toList());

        System.out.println(collect);
    }


    public void sortingByWeight() {
        List<Commodity> collect = commodityList.stream()
                .sorted(Comparator.comparing(Commodity::getWeight))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public void displayCommodity() {
        System.out.println("Введіть індекс товару, який хочете вивести на екран");
        int index = sc.nextInt();

        try {
            for (int i = 0; i < commodityList.size(); i++) {
                if (i == index) {
                    System.out.println(commodityList.get(index));
                }

            }
        } catch (IndexOutOfBoundsException e) {

        }

    }


    public static int getRandomInt(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }


}






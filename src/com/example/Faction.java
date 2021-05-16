package com.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {

    String factionName;

    List<Deputies> faction = new ArrayList<>();


    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public Faction() {

    }

    Supplier<Deputies>  deputiesFactory = ()-> {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name :");
        String name = sc.next();
        System.out.println("Enter lastName : ");
        String lastName = sc.next();
        System.out.println("Enter age : ");
        int age = sc.nextInt();
        try {
            Deputies dep = new Deputies(getRandomInt(70,150), getRandomInt(170, 210),lastName,name, age, getRandomBoolean() );
            if(dep.isGrafter() == true){
                dep.giveBribe(getRandomInt(3000,10000));
            }
            faction.add(dep);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new Deputies();
    };

    /**
     * Метод додає депутатів в список фракціі.
     * З консолі просить ввести: ім'я, прізвище та вік.
     * Інші дані додаються рандомно
     * Якщо поле "хабарник" = true, то додає суму хабаря.
     */
    public void addDeputies() throws IllegalAccessException {
        Deputies deputy = deputiesFactory.get();
    }

    /**
     * Метод видаляє депутутата зі списку фракції за ім'ям та прізвищем
     */
    public void removeDeputy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть прізвище депутата : ");
        String lastName = scan.next();
        System.out.println("Введіть ім'я депутата : ");
        String name = scan.next();

        Deputies deputies = faction
                .stream()
                .filter(dep -> dep.getLastName().equals(lastName) & dep.getName().equals(name))
                .findFirst()
                .get();
        faction.remove(deputies);
    }

    /**
     * Метод виводить список депутатів хабарників,
     * та рандомно додає сумму хабаря.
     */
    public void allGrafter() {

        List<Deputies> deputies = faction
                .stream()
                .filter(e -> e.isGrafter() == true)
                .collect(Collectors.toList());
        System.out.println(deputies);
    }

    /**
     * Метод виводить найбільшого хабарника
     */
    public void bigGrafter() {


        Optional<Deputies> deputies = faction
                .stream()
                .max(Comparator.comparing(e -> e.getSizeOfBribe()));
        deputies
                .ifPresent(maxBribe -> System.out.println(maxBribe));

    }

    /**
     * Метод виводить на екран список всіх депутатів фракції
     */
    public void allDeputies() {
        System.out.println(faction);
    }

    /**
     * Метод видаляє всіх депутатів з фракції
     */



    public void removeAllDeputies() {
        faction.removeAll(faction);
    }


    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static int getRandomInt(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }


    @Override
    public String toString() {
        return "Faction { " +
                "'" + factionName + '\'' +
                "=" + faction +
                '}';
    }
}


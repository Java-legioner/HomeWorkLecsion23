package com.example;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Supplier;

public class VerhovnaRada {

    private static VerhovnaRada instance;
    private ArrayList<Faction> verhovnaRada = new ArrayList<Faction>();
    Scanner sc = new Scanner(System.in);



    private VerhovnaRada() {

    }
    public static VerhovnaRada getInstance() {
        if (instance == null) {
            instance = new VerhovnaRada();
        }
        return instance;
    }

    Supplier<Faction> factionFactory = ()-> {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter faction name :");
        String factionName = sc.next();
        boolean flag = false;

        for(Faction faction : verhovnaRada){
            if(faction.factionName.equals(factionName)){
                flag = true;
            }
        }
        if (flag){
            System.out.println("There is a faction with this name");
        }

        if(!flag){
            verhovnaRada.add(new Faction(factionName));
        }
        return new Faction(factionName);
    };

    /**
     * Метод додає нову фракцію
     */
    public void addFaction() {
        Faction faction = factionFactory.get();
        System.out.println(verhovnaRada);

    }

    /**
     * Метод видаляє фракцію зі списку верховної ради.
     */
    public void removeFaction() {
        System.out.println("Enter faction name : ");
        String factionName = sc.next();

        Faction factions = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        verhovnaRada.remove(factions);

        System.out.println(verhovnaRada);
    }

    /**
     * Метод виводить список всіх фракцій
     */
    public void allFaction() {
        verhovnaRada.forEach(System.out::println);
    }

    /**
     * Виводить вказану фракцію на екран
     * */
    public void displayFaction(){
        System.out.println("Enter faction name :");
        String factionName = sc.next();
        Faction faction = verhovnaRada
                .stream()
                .filter(v -> v.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();

        System.out.println(faction);
    }

    /**
     * Метод додає депутата до вказаної фракції
     * */
    public void addDeputyInFaction() throws IllegalAccessException {
        System.out.println("Enter the name of the faction to which to add the deputy:");
        String factionName = sc.next();

        Faction faction = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.addDeputies();

        System.out.println(verhovnaRada);
    }

    /**
     * Видаляє депутата з вказаної фракцїї.
     * */
    public void removeDeputyFromFaction() {
        System.out.println("Enter the name of the faction from which to remove the deputy :");
        String factionName = sc.next();

        Faction faction = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.removeDeputy();

        System.out.println(verhovnaRada);
    }

    /**
     * Метод виводить всіх депутатів хабарників з вказаної фракції.
     * */
    public void allGrafterInFaction() {
        System.out.println("Enter faction name:");
        String factionName = sc.next();

        Faction faction = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.allGrafter();
    }

    /**
     * Меьод виводить найбільшого хабарника фракції.
     * */
    public void bigGrafterInFaction() {
        System.out.println("Enter faction name:");
        String factionName = sc.next();
        Faction faction = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.bigGrafter();

    }

    /**
     * Метод виводить всіх депутатів фракції.
     * */
    public void allDeputyInFaction() {
        System.out.println("Enter faction name:");
        String factionName = sc.next();
        Faction faction = verhovnaRada
                .stream()
                .filter(f -> f.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.allDeputies();
    }

    /**
     * Метод видаляє всіх депутатів з фракції.
     * */
    public void removeAllDeputiesFromFaction(){
        System.out.println("Enter faction name:");
        String factionName = sc.next();

        Faction faction = verhovnaRada
                .stream()
                .filter(e -> e.factionName.equalsIgnoreCase(factionName))
                .findFirst()
                .get();
        faction.removeAllDeputies();
        System.out.println(faction);
    }



}


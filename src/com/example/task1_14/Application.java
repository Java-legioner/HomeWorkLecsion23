package com.example.task1_14;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Application {

    public static void main(String[] args) {

        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Vasyl", 25));
        persons.add(new Person("Oleh", 37));
        persons.add(new Person("Igor", 15));
        persons.add(new Person("Vitaliy", 54));
        persons.add(new Person("Alex", 52));
        persons.add(new Person("Nazar", 18));
        persons.add(new Person("Igor", 35));
        persons.add(new Person("Alex", 22));

        persons.forEach(System.out::println);

        System.out.println();

        // Сортування за допомогою Comparator
        TreeSet<Person> personsTreeSet = new TreeSet(new PersonComparator());
        personsTreeSet.addAll(persons);
        personsTreeSet.forEach(System.out::println);


        System.out.println();

        // Сортування за допомогою Comparable
        TreeSet<Person> personsTreeSet2 = new TreeSet();
        personsTreeSet2.addAll(persons);
        personsTreeSet2.forEach(System.out::println);

    }
}

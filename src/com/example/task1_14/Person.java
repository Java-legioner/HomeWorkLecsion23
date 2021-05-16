package com.example.task1_14;

import java.util.Objects;

public class Person implements Comparable<Person> {
    String  name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.getName()) > 0){
            return 1;
        }else if(this.name.compareTo(o.getName()) < 0){
            return -1;
        }else{
            if(this.age > o.getAge()){
                return 1;
            }else if(this.age < o.getAge()){
                return -1;
            }
        }
        return 0;
    }
}


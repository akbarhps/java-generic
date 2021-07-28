package com.charuniverse.javageneric.m_comparator_interface;

import com.charuniverse.javageneric.l_comparable_interface.Person;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Anonymous Class
        Comparator<Person> comparator1 = new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        // Lambda
        Comparator<Person> comparator2 = (o1, o2) -> o1.getName().compareTo(o2.getName());

        // Comparator.comparing();
        Comparator<Person> comparator3 = Comparator.comparing(Person::getName);

        Person[] people = {
                new Person("Putra"),
                new Person("Siregar"),
                new Person("Hasadi"),
                new Person("Akbar"),
        };

        System.out.println("Before Sort");
        System.out.println(Arrays.toString(people));

        // Disini kita override method compareTo yang ada di class Person
        Arrays.sort(people, comparator1);
        Arrays.sort(people, comparator2);
        Arrays.sort(people, comparator3);

        System.out.println("After Sort");
        System.out.println(Arrays.toString(people));
    }
}

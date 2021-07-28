package com.charuniverse.javageneric.l_comparable_interface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Putra"),
                new Person("Siregar"),
                new Person("Hasadi"),
                new Person("Akbar"),
        };

        System.out.println("Before Sort");
        System.out.println(Arrays.toString(people));

        // Person harus implement Comparable untuk menggunakan
        // Arrays.sort();
        Arrays.sort(people);

        System.out.println("After Sort");
        System.out.println(Arrays.toString(people));
    }
}

package com.charuniverse.javageneric.d_generic_method;

public class Main {
    public static <E> int count(E[] array) {
        return array.length;
    }

    public static void main(String[] args) {
        Integer[] arrayInteger = {1, 2, 3, 4, 5};
        System.out.println(count(arrayInteger));

        String[] arrayString = {"Akbar", "Hasadi", "Putra", "Siregar"};
        System.out.println(count(arrayString));

        Boolean[] arrayBoolean = {false, true, true, false, false, true};
        System.out.println(count(arrayBoolean));
    }
}

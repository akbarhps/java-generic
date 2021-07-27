package com.charuniverse.javageneric.d_generic_method;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInteger = {1, 2, 3, 4, 5};
        System.out.println(ArrayHelper.count(arrayInteger));

        String[] arrayString = {"Akbar", "Hasadi", "Putra", "Siregar"};
        System.out.println(ArrayHelper.count(arrayString));

        Boolean[] arrayBoolean = {false, true, true, false, false, true};
        System.out.println(ArrayHelper.count(arrayBoolean));
    }
}

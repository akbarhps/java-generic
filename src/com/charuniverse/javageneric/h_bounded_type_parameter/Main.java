package com.charuniverse.javageneric.h_bounded_type_parameter;

public class Main {
    public static void main(String[] args) {
        NumberData<Integer> numberInteger = new NumberData<>(12);
        System.out.println(numberInteger);
        System.out.println(numberInteger.getData().getClass());

        NumberData<Float> numberFloat = new NumberData<>(12f);
        System.out.println(numberFloat);
        System.out.println(numberFloat.getData().getClass());

        // NumberData<String> string = new NumberData<String>("Test");
        // error
    }
}

package com.charuniverse.javageneric.c_multiple_parameter_type;

public class Main {
    public static void main(String[] args) {
        MyPair<String, String> myPair = new MyPair<>("name", "Akbar");
        System.out.println(myPair);
    }
}

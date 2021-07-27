package com.charuniverse.javageneric.b_generic_class;

public class Main {
    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Contoh Data");
        System.out.println(dataString.getData());

        MyData<Integer> dataInteger = new MyData<>(1);
        dataInteger.setData(123);
        System.out.println(dataInteger.getData());

        MyData<Boolean> dataBoolean = new MyData<>(false);
        System.out.println(dataBoolean.getData());
    }
}

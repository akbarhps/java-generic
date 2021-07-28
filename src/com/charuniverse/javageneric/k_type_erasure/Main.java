package com.charuniverse.javageneric.k_type_erasure;

import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    public static void main(String[] args) {
        MyData dataString = new MyData<>("Data String");
        // IntelliJ memberikan warning karena tidak mendeklarasikan generic type

        MyData<Integer> dataInteger = dataString;
        // warning lagi karena tidak dilakukan ketika assign dataString ke dataInteger

        // Integer integer = dataInteger.getData();
        // Error ClassCastException terjadi
    }
}

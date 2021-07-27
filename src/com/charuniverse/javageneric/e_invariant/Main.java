package com.charuniverse.javageneric.e_invariant;

import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Akbar");
        // MyData<Object> dataObject = dataString; // error

        MyData<Object> dataObject = new MyData<>("String");
        // dataString = dataObject // error
    }
}

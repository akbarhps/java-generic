package com.charuniverse.javageneric.j_wildcard;

import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    public static void print(MyData<?> myData) {
        System.out.println(myData.getData().getClass());
        System.out.println(myData);
    }

    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Ini data string");
        print(dataString);

        MyData<?> dataFloat = new MyData<>(100.330f);
        print(dataFloat);

        print(new MyData<>(false));
    }
}

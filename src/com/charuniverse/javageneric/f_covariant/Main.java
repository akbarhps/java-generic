package com.charuniverse.javageneric.f_covariant;

import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    /**
     * Disini terjadi error karena kita tidak boleh merubah datanya setelah
     * di cast menjadi object, karena hal tersebut bisa menyebabkan kita merubah
     * string menjadi int, karena kedua type tersebut extend Object
     * (turunan dari Object).
     */
    public static void cast(MyData<? extends Object> myData) {
        MyData<? extends Object> dataObject = myData;
        System.out.println(dataObject);

        // myData.setData("Hasadi"); // error
        // myData.setData(102); // error
    }

    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Akbar");
        cast(dataString);
    }
}

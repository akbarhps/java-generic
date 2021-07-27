package com.charuniverse.javageneric.d_generic_method;

public class ArrayHelper {
    public static <E> int count(E[] array) {
        return array.length;
    }
}

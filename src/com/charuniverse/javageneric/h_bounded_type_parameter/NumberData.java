package com.charuniverse.javageneric.h_bounded_type_parameter;

public class NumberData<T extends Number> {

    private T data;

    public NumberData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataNumber{" +
                "data=" + data +
                '}';
    }
}

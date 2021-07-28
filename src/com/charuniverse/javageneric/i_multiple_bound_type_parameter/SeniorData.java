package com.charuniverse.javageneric.i_multiple_bound_type_parameter;

/**
 * class ini hanya bisa digunakan subtype(child) Employee yang
 * extends Interface Greetings
 *
 * @param <T>
 */
public class SeniorData<T extends Employee & Greetings> {
    private final T data;

    public SeniorData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SeniorData{" +
                "data=" + data +
                '}';
    }
}

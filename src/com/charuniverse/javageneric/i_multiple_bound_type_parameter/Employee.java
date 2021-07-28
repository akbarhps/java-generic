package com.charuniverse.javageneric.i_multiple_bound_type_parameter;

public abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.charuniverse.javageneric.i_multiple_bound_type_parameter;

public class SeniorEngineer extends Employee implements Greetings {
    public SeniorEngineer(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello this is " + super.getName() + " your Senior Engineer");
    }
}

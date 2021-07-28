package com.charuniverse.javageneric.i_multiple_bound_type_parameter;

public class Main {
    public static void main(String[] args) {
        SeniorEngineer se1 = new SeniorEngineer("Akbar");
        SeniorData<SeniorEngineer> data1 = new SeniorData<>(se1);
        se1.sayHello();

        JuniorEngineer je1 = new JuniorEngineer("Hasadi");
        // SeniorData<JuniorEngineer> data2 = new SeniorData<>(je1);
        // error, JuniorEngineer class tidak implement Interface Greetings
    }
}

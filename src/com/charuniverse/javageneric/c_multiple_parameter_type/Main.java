package com.charuniverse.javageneric.c_multiple_parameter_type;

public class Main {
    static class MyPair<T, U> {
        private T first;
        private U second;

        public MyPair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond(U second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "MyPair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyPair<String, String> myPair = new MyPair<>("name", "Akbar");
        System.out.println(myPair);
    }
}

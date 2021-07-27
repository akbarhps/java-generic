package com.charuniverse.javageneric.a_pengenalan_generic;

public class Main {
    static class Data<T> {
        private T data;

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Data<String> data = new Data<>();
        data.setData("Contoh Data");
        System.out.println(data.getData());
    }
}

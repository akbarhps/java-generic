package com.charuniverse.javageneric.g_contravariant;

import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    public static void cast(MyData<? super Integer> myData) {
        System.out.println(myData.getData().getClass());
        // class java.lang.String

        myData.setData(100);
        System.out.println(myData.getData().getClass());
        //class java.lang.Integer

        // Integer dataString = (Integer) myData.getData();
        // System.out.println(dataString);
        // Cara diatas berbahaya karena kita tidak bisa memastikan data yang
        // diterima merupakan Integer (karena dikirim sebagai Object)
        // Object bisa saja diisi dengan String ataupun type lainnya!
    }

    public static void main(String[] args) {
        MyData<Object> dataObject = new MyData<>("Akbar Ganteng");
        cast(dataObject);
    }
}

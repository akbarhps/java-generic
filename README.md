# Java Generic

Generic programming is a style of computer programming in which algorithms are written in terms of types
to-be-specified-later that are then instantiated when needed for specific types provided as parameters.
[Wikipedia](https://en.wikipedia.org/wiki/Generic_programming)

## Pengenalan Generic

- Generic adalah kemampuan menambahkan parameter type saat membuat class atau method
- Berbeda dengan tipe data yang kita gunakan di class atau function, generic memungkinkan kita bisa merubah type data
  sesuai yang kita mau

## Generic Class

- Generic class adalah class atau interface yang memiliki parameter type
- Tidak ada ketentuan dalam pembuatan generic parameter type
- Nama generic parameter yang biasa digunakan:
    - E - Element (biasa digunakan di collection atau struktur data)
    - K - Key
    - N - Number
    - T - Type
    - V - Value
    - S, U, V etc. (2nd, 3rd, 4th types)

p.s: nama di atas tidak wajib, hanya saja nama di atas sering digunakan

p.p.s: nama generic parameter biasanya hanya 1 huruf, hal ini bertujuan untuk membedakan antara generic parameter type
dengan class

Contoh:

```java
public class MyData<T> {
    private T data;

    public MyData(T data) {
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
        return "MyData{" +
                "data=" + data +
                '}';
    }
}
```

## Multiple Parameter Type

- Parameter type di generic class boleh lebih dari satu
- Namun harus menggunakan nama type berbeda

Contoh:

```java
public class MyPair<T, U> {
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
```

## Generic Method

- Kita juga bisa menggunakan generic parameter pada method
- Generic parameter type yang kita deklarasikan di method, hanya dapat di akses di method tersebut.
- Ini cocok jika kita ingin membuat generic method tanpa harus mengubah deklarasi class

Contoh:

```java
public class ArrayHelper {
    public static <E> int count(E[] array) {
        return array.length;
    }
}
```

## Invariant

- Secara default, saat kita membuat generic parameter type, sifat parameter tersebut adalah invariant
- Invariant artinya tidak boleh di subtitusi dengan subtype(child) ataupun supertype(parent)
- Artinya saat kita membuat object ```MyData<String>```, object tersebut tidaklah sama dengan ```MyData<Object>``` dan
  sebaliknya  ```MyData<Object>``` tidak sama dengan ```MyData<String>```

p.s: String merupakan turunan dari Object

p.p.s: Harusnya kita bisa casting String ke Object dan sebaliknya

p.p.p.s: Inti dari invariant itu data subtype(child) tidak bisa di cast menjadi supertype(parent) dan sebaliknya

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Akbar");
        // MyData<Object> dataObject = dataString; // error

        MyData<Object> dataObject = new MyData<>("Hasadi");
        // dataString = dataObject // error
    }
}
```

## Covariant

- Covariant artinya kita bisa melakukan subtitusi subtype(child) dengan supertype(parent)
- Caranya agar generic object kita menjadi covariant adalah dengan menggnakan kata kunci (? extends ParentClass)
- Contohnya ketika kita membuat object ```MyData<String>```, maka bisa di subtitusi
  dengan ```MyData<? extends Object>```
- Covariant bersifat read-only, jadi kita tidak bisa merubah data generic nya

p.s: Covariant hanya read-only karena kita tidak boleh merubah data subtype(child) setelah di cast menjadi supertype(
parent), hal tersebut bisa menyebabkan kita merubah string menjadi int, karena kedua type tersebut extend Object (
turunan dari Object).

Contoh:

```java
 public class Main {
    public static void cast(MyData<? extends Object> myData) {
        MyData<? extends Object> dataObject = myData;
        System.out.println(dataObject);

        // myData.setData("Hasadi"); // error read-only
        // myData.setData(102); // error read-only
    }

    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Akbar");
        cast(dataString);
    }
}
```

## Contravariant

- Contravariant artinya kita bisa melakukan subtitusi supertype(parent) dengan subtype(child)
- Caranya agar generic object kita menjadi contravariant adalah dengan menggunakan kata kunci (? super SubClass)
- Contohnya ketika kita membuat object ```MyData<Object>```, maka bisa di subtitusi dengan ```MyData<? super String>```
- Contravariant bersifat read dan write, namun perlu berhati-hati ketika melakukan read, terutama jika parentnya
  memiliki banyak child

p.s: Sebisa mungkin hindari read data, karena supertype(parent) biasanya memiliki banyak subtype(child) hal ini bisa
menyebabkan terjadinya ```ClassCastException```

p.p.s: Error yang terjadi pada Contravariant merupakan runtime error, sehingga ketika harus lebih teliti dalam
menggunakan Contravariant

Contoh:

```java
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
    }

    public static void main(String[] args) {
        MyData<Object> dataObject = new MyData<>("Akbar Ganteng");
        cast(dataObject);
    }
}
```

## Bounded Type Parameter

- Kadang kita ingin membatasi data yang boleh digunakan di generic parameter type
- Kita bisa menambahkan constraint di generic parameter type dengan menyebutkan tipe yang diperbolehkan
- Secara otomatis, type data yang bisa digunakan adalah type yang sudah kita sebutkan, atau class turunannya
- Secara default, constraint type untuk generic parameter type adalah Object, sehingga semua tipe data bisa digunakan

Contoh:

```java
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
```

## Multiple Bounded Type Parameter

- Kadang kita ingin membatasi lebih dari 1 type parameter
- Kita bisa menambahkan beberapa bounded type parameter dengan karakter ```&``` setelah bounded type pertama, dst.
- Bounded type parameter pertama boleh _Class_, tetapi yang kedua dst hanya boleh _Interface_. Hal ini dikarenakan kita
  hanya boleh memiliki 1 parent class.

p.s: _Multiple Bounded Type Parameter Class_ tersebut hanya bisa digunakan oleh _Parent Class_ dan turunannya yang
implement semua _Interface_ dari _Multiple Bounded Type Parameter_

Contoh:

```java
public interface Greetings {
    void sayHello(String name);
}

public static abstract class Employee {
}

public static class JuniorEngineer extends Employee {
}

public static class SeniorEngineer extends Employee implements Greetings {
}

public class SeniorData<T extends Employee & Greetings> {
    private final T data;

    public SeniorData(T data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        SeniorEngineer se = new SeniorEngineer("Akbar");
        SeniorData<SeniorEngineer> sd1 = new SeniorData<>(se);
        se1.sayHello();

        JuniorEngineer je = new JuniorEngineer("Hasadi");
        // SeniorData<JuniorEngineer> sd2 = new SeniorData<>(je);
        // error, class JuniorEngineer tidak implement Interface Greetings
    }
}
```

## Wildcard

- Kadang ada kasus kita tidak perduli dengan generic parameter type pada Object
- Contohnya ketika kita ingin print data T, maka type parameter type tidaklah penting
- Wildcard bisa dibuat dengan mengganti generic parameter type dengan karakter ?

p.s: Hindari meng-inisialisasi variable dan data variable dari Wildcard karena kita tidak tahu data apa yang dimasukkan
sebagai parameter

Contoh:

```java
import com.charuniverse.javageneric.b_generic_class.MyData;

public class Main {
    public static void print(MyData<?> myData) {
        System.out.println(myData);
    }

    public static void main(String[] args) {
        MyData<String> dataString = new MyData<>("Ini data string");
        print(dataString);

        MyData<?> dataFloat = new MyData<>(100.330f);
        print(dataFloat);

        print(new MyData<>(false));
    }
}
```

## Type Erasure

- Type Erasure adalah proses pengecekan generic pada saat compile time, dan menghiraukan pengecakan pada saat runtime
- Type Erasure menjadikan informasi generic yang kita buat akan hilang ketika kode program kita telah di compile menjadi
  binary file
- Compiler akan mengubah generic parameter type menjadi type Object

Contoh:

```java
public class Main {
    public static void main(String[] args) {
        MyData dataString = new MyData<>("Data String");
        // warning karena tidak mendeklarasikan generic type
        // Raw use of parameterized class 'MyData' 

        MyData<Integer> dataInteger = dataString;
        // warning lagi karena ketika assign dataString ke dataInteger
        // Unchecked assignment: 'com.charuniverse.javageneric.b_generic_class.MyData' to 'com.charuniverse

        // Integer integer = dataInteger.getData();
        // Error ClassCastException
        // class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
    }
}
```
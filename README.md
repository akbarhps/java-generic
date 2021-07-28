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

p.p.p.s: Inti dari invariant itu data subtype(child) tidak bisa di cast menjadi supertype(parent) dan
sebaliknya

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
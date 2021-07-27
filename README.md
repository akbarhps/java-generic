# Java Generic

---

## Pengenalan Generic

- Generic adalah kemampuan menambahkan parameter type saat membuat class atau method
- Berbeda dengan tipe data yang kita gunakan di class atau function, generic memungkinkan kita bisa merubah type data
  sesuai yang kita mau

---

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
p.p.s: nama generic parameter biasanya hanya 1 huruf, hal berjutuan untuk membedakan antara generic parameter type
dengan class

Contoh:

```java
static class MyData<T> {
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
}
```

---

## Multiple Parameter Type

- Parameter type di generic class boleh lebih dari satu
- Namun harus menggunakan nama type berbeda

Contoh:

```java
public static class MyPair<T, U> {
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
# Java Generic

---

## Pengenalan Generic

- Generic adalah kemampuan menambahkan parameter type saat membuat class atau method
- Berbeda dengan tipe data yang kita gunakan di class atau function, generic memungkinkan kita bisa merubah type data
  sesuai yang kita mau

Contoh Generic:

```java
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
    }
}
```

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
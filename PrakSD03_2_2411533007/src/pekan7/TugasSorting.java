package ex;

public class TugasSorting {
    // Function Bubble Sort urutan ascending
    public static void bubbleSort(char[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    char temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] huruf = {
            'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q',
            'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g',
            'f', 'e', 'd', 'c', 'b', 'a'
        };

        // Mengambil 7 elemen pertama karena NIM akhiran 07 dan jalur Mandiri
        char[] diurutkan = new char[7];
        for (int i = 0; i < 7; i++) {
            diurutkan[i] = huruf[i];
        }
        // Memenggail funcion bublesort
        bubbleSort(diurutkan);
        // Gabungkan hasil sorting dengan array
        char[] hasil = new char[huruf.length];
        for (int i = 0; i < 7; i++) {
            hasil[i] = diurutkan[i];
        }
        for (int i = 7; i < huruf.length; i++) {
            hasil[i] = huruf[i];
        }
        // Menampilkan hasil akhir array yang sudah diurutkan
        for (int i = 0; i < hasil.length; i++) {
            System.out.print(hasil[i]);
            if (i != hasil.length - 1) {
                System.out.print(" - ");
            }
        }
    }
}

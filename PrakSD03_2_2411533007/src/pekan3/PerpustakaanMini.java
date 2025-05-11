package pekan3;
import java.util.Scanner;
import java.util.Stack;

// Class Buku: menyimpan judul buku
class Buku {
    private String judul; // atribut judul buku

    // Konstruktor: inisialisasi judul buku
    public Buku(String judul) {
        this.judul = judul;
    }

    // Getter untuk mendapatkan judul buku
    public String getJudul() {
        return judul;
    }
}

// Class PerpustakaanMini: simulasi tumpukan buku LIFO menggunakan Stack
public class PerpustakaanMini {
    private Stack<Buku> tumpukanBuku; // struktur data LIFO untuk buku

    // Konstruktor: inisialisasi tumpukan dan tambah 7 buku awal
    public PerpustakaanMini() {
        tumpukanBuku = new Stack<>();
        tumpukanBuku.push(new Buku("Algoritma Dasar"));
        tumpukanBuku.push(new Buku("Struktur Data"));
        tumpukanBuku.push(new Buku("Basis Data"));
        tumpukanBuku.push(new Buku("Pemrograman Java"));
        tumpukanBuku.push(new Buku("Jaringan Komputer"));
        tumpukanBuku.push(new Buku("Sistem Operasi"));
        tumpukanBuku.push(new Buku("Kecerdasan Buatan"));
    }

    // Method tambahBuku: menambahkan buku ke atas tumpukan
    public void tambahBuku(Buku buku) {
        tumpukanBuku.push(buku);
        System.out.println("Buku \"" + buku.getJudul() + "\" berhasil ditambahkan ke tumpukan.");
    }

    // Method ambilBuku: mengambil buku teratas dari tumpukan
    public void ambilBuku() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong, tidak ada buku untuk diambil.");
        } else {
            Buku b = tumpukanBuku.pop(); // pop LIFO
            System.out.println("Buku diambil: " + b.getJudul());
        }
    }

    // Method lihatTumpukan: menampilkan semua buku di tumpukan
    public void lihatTumpukan() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong.");
        } else {
            System.out.println("Tumpukan Buku Saat Ini:");
            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
                System.out.println("- " + tumpukanBuku.get(i).getJudul());
            }
        }
    }

    // Method cariBuku: memeriksa apakah judul tertentu ada di tumpukan
    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (Buku b : tumpukanBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                ditemukan = true;
                break;
            }
        }
        if (ditemukan) {
            System.out.println("Buku \"" + judul + "\" ada di tumpukan.");
        } else {
            System.out.println("Buku \"" + judul + "\" tidak ditemukan.");
        }
    }

    // Main: interaktif dengan Scanner
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        PerpustakaanMini lib = new PerpustakaanMini(); // buat instance
        int pilihan;

        do {
            // Tampilkan menu
            System.out.println("=== MENU PERPUSTAKAAN MINI ===");
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Cari Buku di Tumpukan");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = console.nextInt();
            console.nextLine(); // clear newline

            // Proses pilihan
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judulTambah = console.nextLine().trim(); // hilangkan whitespace
                    if (judulTambah.isEmpty()) {
                        System.out.println("Tolong inputkan judul buku.");
                    } else {
                        lib.tambahBuku(new Buku(judulTambah));
                    }
                    break;
                case 2:
                    lib.ambilBuku();
                    break;
                case 3:
                    lib.lihatTumpukan();
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String judulCari = console.nextLine().trim();
                    if (judulCari.isEmpty()) {
                        System.out.println("Tolong inputkan judul buku yang dicari.");
                    } else {
                        lib.cariBuku(judulCari);
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println(); // spasi
        } while (pilihan != 5);

        console.close();
    }
}

package 5;
import java.util.Scanner;

public class AntrianPasien {
    // Node dalam Linked List
    private static class Node {
        int noAntrian;
        String nama;
        String keluhan;
        Node next;

        Node(int noAntrian, String nama, String keluhan) {
            this.noAntrian = noAntrian;
            this.nama = nama;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    private Node head = null;

    // Menambah pasien ke akhir antrian
    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node baru = new Node(noAntrian, nama, keluhan);
        if (head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
        System.out.println("\nData pasien berhasil ditambahkan!");
    }

    // Menampilkan seluruh antrian pasien
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            Node temp = head;
            System.out.println("--- Daftar Antrian Pasien ---");
            int i = 1;
            while (temp != null) {
                System.out.println(i + ". [" + temp.noAntrian + "] " + temp.nama + " - " + temp.keluhan);
                temp = temp.next;
                i++;
            }
        }
    }

    // Menghapus pasien pertama dari antrian
    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada pasien yang dapat dilayani.");
        } else {
            String nama = head.nama;
            head = head.next;
            System.out.println("Pasien dengan nama " + nama + " telah dilayani (dihapus dari antrian).");
        }
    }

    // Mencari pasien berdasarkan nama
    public void cariPasien(String namaCari) {
        Node temp = head;
        boolean ditemukan = false;
        while (temp != null) {
            if (temp.nama.equalsIgnoreCase(namaCari)) {
                System.out.println("Pasien ditemukan:");
                System.out.println("Nomor Antrian: " + temp.noAntrian);
                System.out.println("Nama: " + temp.nama);
                System.out.println("Keluhan: " + temp.keluhan);
                ditemukan = true;
                break;
            }
            temp = temp.next;
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama \"" + namaCari + "\" tidak ditemukan.");
        }
    }

    // Mengecek apakah antrian kosong
    public boolean isEmpty() {
        return head == null;
    }

    // Menghitung jumlah pasien
    public int hitungPasien() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Main menu
    public static void main(String[] args) {
        AntrianPasien antrian = new AntrianPasien();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN PASIEN KLINIK ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = scanner.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;

                case 2:
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    antrian.hapusPasienPertama();
                    break;

                case 4:
                    System.out.print("Masukkan nama pasien yang dicari: ");
                    String cari = scanner.nextLine();
                    antrian.cariPasien(cari);
                    break;

                case 5:
                    System.out.println("Jumlah pasien saat ini: " + antrian.hitungPasien());
                    break;

                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (pilihan != 6);

        scanner.close();
    }
}

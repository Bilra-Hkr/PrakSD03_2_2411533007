package ex;
import java.util.Scanner;

 class ItemBelanja {
    String nama;
    int kuantitas;
    String kategori;

    public ItemBelanja(String nama, int kuantitas, String kategori) {
        this.nama = nama;
        this.kuantitas = kuantitas;
        this.kategori = kategori;
    }
}
 
 class Node {
	 ItemBelanja data;
	 Node prev;
	 Node next;

	 public Node(ItemBelanja data) {
		 this.data = data;
	     this.prev = null;
	     this.next = null;
	 }
 }
 
 public class DaftarBelanja {
     private Node head;
     private Node tail;

     public void tambahItem(String nama, int kuantitas, String kategori) {
         ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
         Node baru = new Node(item);

         if (head == null) {
             head = tail = baru;
         } else {
             tail.next = baru;
             baru.prev = tail;
             tail = baru;
         }

         System.out.println("Item berhasil ditambahkan!");
     }

     public void hapusItem(String nama) {
         Node current = head;

         while (current != null) {
             if (current.data.nama.equalsIgnoreCase(nama)) {
                 if (current == head && current == tail) {
                     head = tail = null;
                 } else if (current == head) {
                     head = current.next;
                     head.prev = null;
                 } else if (current == tail) {
                     tail = current.prev;
                     tail.next = null;
                 } else {
                     current.prev.next = current.next;
                     current.next.prev = current.prev;
                 }

                 System.out.println("Item berhasil dihapus.");
                 return;
             }
             current = current.next;
         }

         System.out.println("Item tidak ditemukan.");
     }

     public void tampilkanSemuaItem() {
         if (head == null) {
             System.out.println("Daftar belanja kosong.");
             return;
         }

         System.out.println("--- Daftar Belanja ---");
         Node current = head;
         while (current != null) {
             System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
             current = current.next;
         }
     }

     public void tampilkanPerKategori(String kategori) {
         boolean ditemukan = false;
         Node current = head;

         System.out.println("--- Item dalam kategori '" + kategori + "' ---");
         while (current != null) {
             if (current.data.kategori.equalsIgnoreCase(kategori)) {
                 System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ")");
                 ditemukan = true;
             }
             current = current.next;
         }

         if (!ditemukan) {
             System.out.println("Tidak ada item dalam kategori tersebut.");
         }
     }

     public void cariItem(String nama) {
         Node current = head;
         while (current != null) {
             if (current.data.nama.equalsIgnoreCase(nama)) {
                 System.out.println("Item ditemukan:");
                 System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
                 return;
             }
             current = current.next;
         }
         System.out.println("Item tidak ditemukan.");
     }

     public static void main(String[] args) {
         DaftarBelanja daftar = new DaftarBelanja();
         Scanner scanner = new Scanner(System.in);
         int pilihan;

         do {
             System.out.println("\n=== MENU DAFTAR BELANJA ===");
             System.out.println("1. Tambah Item");
             System.out.println("2. Hapus Item");
             System.out.println("3. Tampilkan Semua Item");
             System.out.println("4. Tampilkan Item Berdasarkan Kategori");
             System.out.println("5. Cari Item");
             System.out.println("6. Keluar");
             System.out.print("Pilih menu: ");
             pilihan = scanner.nextInt();
             scanner.nextLine(); // newline

             switch (pilihan) {
                 case 1:
                     System.out.print("Masukkan nama item: ");
                     String nama = scanner.nextLine();
                     System.out.print("Masukkan kuantitas: ");
                     int qty = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Masukkan kategori: ");
                     String kategori = scanner.nextLine();
                     daftar.tambahItem(nama, qty, kategori);
                     break;
                 case 2:
                     System.out.print("Masukkan nama item yang ingin dihapus: ");
                     String hapusNama = scanner.nextLine();
                     daftar.hapusItem(hapusNama);
                     break;
                 case 3:
                     daftar.tampilkanSemuaItem();
                     break;
                 case 4:
                     System.out.print("Masukkan kategori: ");
                     String kategoriFilter = scanner.nextLine();
                     daftar.tampilkanPerKategori(kategoriFilter);
                     break;
                 case 5:
                     System.out.print("Masukkan nama item yang dicari: ");
                     String cariNama = scanner.nextLine();
                     daftar.cariItem(cariNama);
                     break;
                 case 6:
                     System.out.println("Terima kasih, program selesai.");
                     break;
                 default:
                     System.out.println("Pilihan tidak valid.");
             }

         } while (pilihan != 6);

         scanner.close();
     }
 }




package ex;
import java.util.*;

class Mobil {											// Mendefinisikan class mobil
    private String platNomor; 							// Deklarasi attribut plat nomor mobil secara enkapsulasi
    // Konstruktor kelas Mobil yang menerima plat nomor sebagai parameter
    public Mobil(String platNomor) {
        this.platNomor = platNomor;
    }
    // Getter untuk mengambil plat nomor mobil
    public String getPlatNomor() {
        return platNomor;
    }
}

 class Parkir {
    private ArrayList<Mobil> daftarMobil = new ArrayList<>(); 
    
    public Parkir() {
        // Inisialisasi mobil awal
    	daftarMobil.add(new Mobil("AB123CD"));
        daftarMobil.add(new Mobil("B456EF"));
        daftarMobil.add(new Mobil("D789GH"));
        daftarMobil.add(new Mobil("F101IJ"));
        daftarMobil.add(new Mobil("H112KL"));
        daftarMobil.add(new Mobil("L131MN"));
        daftarMobil.add(new Mobil("N415OP"));
    }

    // Function menambahkan mobil baru ke parkiran
    public void tambahMobil(String platNomor) {
        daftarMobil.add(new Mobil(platNomor));
        System.out.println("Mobil dengan plat '" + platNomor + "' berhasil ditambahkan.");
    }

    //Function mengeluarkan mobil berdasarkan plat nomor
    public void keluarkanMobil(String platNomor) {
    	int index = -1;
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            daftarMobil.remove(index);
            System.out.println("Mobil dengan plat '" + platNomor + "' berhasil dikeluarkan.");
        } else {
            System.out.println("Mobil dengan plat '" + platNomor + "' tidak ditemukan.");
        }
    }

    // Function menampilkan semua mobil yang sedang parkir
    public void tampilkanParkiran() {
    	if (daftarMobil.isEmpty()) {
            System.out.println("Parkiran kosong.");
        } else {
            System.out.println("Daftar mobil di parkiran:");
            for (Mobil mobil : daftarMobil) {
                System.out.println("- " + mobil.getPlatNomor());
            }
        }
    }

    // Function mencari mobil berdasarkan plat nomor
    public void cariMobil(String platNomor) {
        boolean ditemukan = false;
        for (Mobil mobil : daftarMobil) {
            if (mobil.getPlatNomor().equals(platNomor)) {
                ditemukan = true;
                break;
            }
        }
        if (ditemukan) {
            System.out.println("Mobil dengan plat '" + platNomor + "' berada di parkiran.");
        } else {
            System.out.println("Mobil dengan plat '" + platNomor + "'tidak ditemukan.");
        }
    }
}

public class Parkiran_Mobil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Parkir parkir = new Parkir(); 
        int pilihan;
        do {
            // Tampilan menu
            System.out.println("=== Menu Parkiran Mobil ===");
            System.out.println("1. Tambah mobil ke Parkiran");
            System.out.println("2. Keluarkan mobil dari Parkiran");
            System.out.println("3. Tampilkan isi Parkiran");
            System.out.println("4. Cari mobil di Parkiran");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt(); 
            scanner.nextLine(); 
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan plat nomor: ");
                    String platTambah = scanner.nextLine();
                    parkir.tambahMobil(platTambah);
                    break;
                case 2:
                    System.out.print("Masukkan plat nomor mobil yang ingin keluar: ");
                    String platKeluar = scanner.nextLine().trim();
                    if (platKeluar.isEmpty()) {
                        System.out.println("Tolong inputkan plat mobil yang sesua.");
                    } else {
                        parkir.keluarkanMobil(platKeluar);
                    }
                    break;
                case 3:
                    parkir.tampilkanParkiran();
                    break;
                case 4:
                    System.out.print("Masukkan plat nomor yang dicari: ");
                    String platCari = scanner.nextLine();
                    parkir.cariMobil(platCari);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            } 
            System.out.println();
        } while (pilihan != 5);

        scanner.close();
    }
}

package pekan1;

import java.util.Scanner;
import java.util.ArrayList;

public class DaftarSiswa {
	private static ArrayList <String> daftarNamaSiswa = new ArrayList <>();
	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		int pilihan;
		do {
			System.out.println("\nmenu :");
			System.out.println("1. Tambah nama siswa");
			System.out.println("2. Tampilan daftar siswa");
			System.out.println("3. Hapus nama siswa");
			System.out.println("4. Cari nama siswa");
			System.out.println("5. Keluar");
			System.out.println("Masukan pilihan anda :");
			pilihan = console.nextInt();
			console.nextLine();		//newline
			switch (pilihan) {
				case 1 :
					tambahNamaSiswa (console);
					break;
				case 2 :
					tampilkanDaftarNamaSiswa ();
					break;
				case 3 :
					hapusNamaSiswa (console);
					break;
				case 4 :
					cariNamaSiswa (console);
					break;
				case 5 :
					System.out.println("Keluar dari program.");
					break;
				default :
					System.out.println("Pilihan tidak valid.");
			}
		} while (pilihan != 5);
	}

	private static void tambahNamaSiswa (Scanner console) {
		System.out.println("Masukan nama siswa :");
		String nama = console.nextLine();
		daftarNamaSiswa.add(nama);
		System.out.println("Nama siswa " + nama + " berhasil ditambahkan.");
	}
	private static void tampilkanDaftarNamaSiswa () {
		if (daftarNamaSiswa.isEmpty()) {
			System.out.println("Tidak ada siswa dalam daftar.");
		} else {
			System.out.println("Daftar Nama Siswa :");
			for (String nama : daftarNamaSiswa) {
				System.out.println(nama);
			}
		}
		System.out.println();
		System.out.println(daftarNamaSiswa);
	}
	private static void hapusNamaSiswa (Scanner console) {
		System.out.println("Silahkan input nama siswa yang ingin dihapus :");
		System.out.println(daftarNamaSiswa);
		String nama = console.nextLine();
		if (daftarNamaSiswa.remove(nama)) {
			System.out.println("Nama siswa berhasil dihapus.");
		} else {
			System.out.println("Nama siswa tidak dapat ditemukan.");
		}
		System.out.println(daftarNamaSiswa);
	}
	private static void cariNamaSiswa (Scanner console) {
		System.out.println("Masukan nama siswa yang ingin dicari :");
		String nama = console.nextLine();
		if (daftarNamaSiswa.contains(nama)) {
			System.out.println("Nama siswa berhasil ditemukan : " + nama + ".");
		} else {
			System.out.println("Nama siswa tidak ditemukan");
		}
	}	
}

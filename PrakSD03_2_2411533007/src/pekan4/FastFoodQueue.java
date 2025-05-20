package ex;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 class Pelanggan {
    private String id;
    private int jumlahPesanan;

    public Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }

    public String getId() {
        return id;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }
}
 
 public class FastFoodQueue {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Queue<Pelanggan> antrian = new LinkedList<>();

	        System.out.print("Masukkan jumlah pelanggan: ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); // konsumsi newline

	        // Input pelanggan
	        for (int i = 0; i < n; i++) {
	            System.out.print("Masukkan ID dan jumlah pesanan (misal: A123 2): ");
	            String[] input = scanner.nextLine().split(" ");
	            String id = input[0];
	            int jumlahPesanan = Integer.parseInt(input[1]);
	            antrian.add(new Pelanggan(id, jumlahPesanan));
	        }

	        int waktuKumulatif = 0;
	        System.out.println();
	        while (!antrian.isEmpty()) {
	            Pelanggan p = antrian.poll();
	            waktuKumulatif += p.getJumlahPesanan();
	            System.out.println(p.getId() + " selesai dalam " + waktuKumulatif + " menit");
	        }

	        scanner.close();
	    }
	}

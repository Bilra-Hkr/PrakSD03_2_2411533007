package pekan8;
import java.util.Arrays;
//Nama : Deriel Chaerahman
//NIM  : 2411533007
public class TugasSortingLanjutan {
	
	public static int[] bilanganPrima() {
     int[] prima = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
     return prima;
	}
 
 	//Method Selection Sort Descending
 	public static void selectionSort(int[] arr) {
 		int n = arr.length;
 		System.out.println("Selection Sort : ");
    
 		for (int i = 0; i < n - 1; i++) {
 			int maxIndex = i;
 			for (int j = i + 1; j < n; j++) {
 				if (arr[j] > arr[maxIndex]) {
                 maxIndex = j;
 				}
 			}
         
 			if (maxIndex != i) {
 				int temp = arr[i];
 				arr[i] = arr[maxIndex];
 				arr[maxIndex] = temp;
 			}
 			System.out.println("Langkah " + (i + 1) + ": " + Arrays.toString(arr));
 		}
 		System.out.println();
 		System.out.println("Hasil akhir : " + Arrays.toString(arr));
 	}
 
 	
	 public static void main(String[] args) {
		 System.out.println("Nama : Deriel Chaerahman");
		 System.out.println("NIM  : 2411533007 \n");
		 
	     int[] prima = bilanganPrima();
	     System.out.println("Deret awal : " + Arrays.toString(prima) + "\n");
	     
	     int[] primaSort = Arrays.copyOf(prima, prima.length);
	     selectionSort(primaSort);
	 	}
}

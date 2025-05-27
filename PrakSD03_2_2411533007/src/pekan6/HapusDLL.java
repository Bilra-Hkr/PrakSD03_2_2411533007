package pekan6;

public class HapusDLL {
	//fungsi menghapus node awal
	public static NodeDLL delHead(NodeDLL head) {
		if (head == null) {
			return null;
		}
		NodeDLL temp = head;
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
		return head;
	}
	
	//fungsi menghapus diakhir
	public static NodeDLL delLast(NodeDLL head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}
		NodeDLL curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		//update pointer previous node
		if (curr.prev != null) {
			curr.prev.next = null;
		}
		return head;
	}
	
	//fungsi menghapus node posisi tertentu
	public static NodeDLL delPos(NodeDLL head, int pos) {
		//jika DLL kosong
		if (head == null) {
			return head;
		}
		NodeDLL curr = head;
		//Telusuri sampai ke node yang akan dihapus
		for (int  i = 1; curr != null && i < pos; i++) {
			curr = curr.next;
		}
		//jika posisi tidka ditemukan
		if (curr == null) {
			return head;
		}
		//Update pointer
		if (curr.prev != null) {
			curr.prev.next = curr.next;
		}
		if (curr.next != null) {
			curr.next.prev = curr.prev;
		}
		//jika yang dihapus head
		if (head == curr) {
			head = curr.next;
		}
		return head;
	}
	
	//fungsi mencetak DLL
	public static void printList (NodeDLL head) { 
		NodeDLL curr = head;
		while (curr != null) { 
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	
	public static void main (String[] args) {
		System.out.println("Nama : Deriel Chaerahman");
		System.out.println("NIM  : 2411533007");
		System.out.println();
		//buat sebuah DLL
		NodeDLL head = new NodeDLL(1);
	    head.next = new NodeDLL(2);
	    head.next.prev = head;
	    head.next.next = new NodeDLL(3);
	    head.next.next.prev = head.next;
	    head.next.next.next = new NodeDLL(4);
	    head.next.next.next.prev = head.next.next;
	    head.next.next.next.next = new NodeDLL(5);
	    head.next.next.next.next.prev = head.next.next.next;
		
		System.out.print("DLL awal: ");
		printList(head);
		
		System.out.print("Setelah head dihapus: ");
		head = delHead(head);
		printList(head);
		
		System.out.print("Setelah node terakhir dihapus: ");
		head = delLast(head);
		printList(head);
		
		System.out.print("Menghapus node ke-2: ");
		head = delPos(head, 2);
		
		printList(head);
	}
}

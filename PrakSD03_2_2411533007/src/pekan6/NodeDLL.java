package pekan6;

public class NodeDLL {
		// Mendefinisikan kelas Node
		int data; //data
		NodeDLL next;	//Pointer ke next node
		NodeDLL prev;	//Pointer ke previous node
		
		//konstruktor
		public NodeDLL(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
}

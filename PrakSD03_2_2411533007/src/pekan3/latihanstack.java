package pekan3;
import java.util.Stack;

public class latihanstack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(43);
		s.push(-3);
		s.push(17);
		System.out.println("Nilai stack = " + s);
		System.out.println("Nilai pop = " + s.pop());
		System.out.println("Nilai stack setelah pop = " + s);
		System.out.println("Nilai peek = " + s.peek());
		System.out.println("Nilai scatk setelah peek = " + s);
	}

}

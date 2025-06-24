package pekan9;
import java.util.*;
public class GraphTraversal {
	private Map<String, List<String>> graph = new HashMap<>();
	
	//Menambahkan edge (graf toal berarah)
	public void addEdge(String node1, String node2) {
		graph.putIfAbsent(node1, new ArrayList<>());
		graph.putIfAbsent(node2, new ArrayList<>());
		graph.get(node1).add(node2);
		graph.get(node2).add(node1);
	}
	
	//menampilkan graf awal
	public void printGraph() {
		System.out.println("Graf awal (Adjacency List): ");
		for (String node : graph.keySet()) {
			System.out.print(node + "-> ");
			List<String> neighbors = graph.get(node);
			System.out.println(String.join(", ", neighbors));
		}
		System.out.println();
	}
	
	//DFS rekursif
	public void dfs(String start) {
		Set<String> visited = new HashSet<>();
		System.out.println("Penelusuran DFS : ");
		dfsHelper(start, visited);
		System.out.println();
	}

	private void dfsHelper(String current, Set<String> visited) {
		if (visited.contains(current)) 
			return;
		visited.add(current);
		System.out.print(current + " ");
		for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
			dfsHelper(neighbor, visited);
		}
	}
	
	//BFS iteratif
	public void bfs (String start) {
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		System.out.println("Penelusurann BFS : ");
		while (!queue.isEmpty()) {
			String current = queue.poll();
			System.out.print(current + " ");
			for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		GraphTraversal graph = new GraphTraversal();
		
		//contoh graf : A-B, A-C, B-D, B-E
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");

		//cetak graf awal
		System.out.println("Graf awal adalah : ");
		graph.printGraph();
		
		//lakukan penelusuran 
		graph.dfs("A");
		graph.bfs("A");
	}
}

package ex;
import java.util.*;
//Nama : Deriel Chaerahman
//NIM : 2411533007

public class TugasSearchingGraf {
    private Map<String, List<String>> graph = new HashMap<>();
    
    public TugasSearchingGraf() {
        initializeGraph();
    }
    
    private void initializeGraph() {
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "E");
        addEdge("C", "F");
        addEdge("D", "G");
        addEdge("E", "F");
        addEdge("E", "H");
        addEdge("F", "G");
        addEdge("G", "H");
    }
    
    public void addEdge(String node1, String node2) {
        graph.putIfAbsent(node1, new ArrayList<>());
        graph.putIfAbsent(node2, new ArrayList<>());
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
    
    public void search(String startNode, String goalNode) {
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);
        System.out.println("Algoritma: DFS");
        System.out.println();
        
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        int[] stepCounter = {1}; 
        
        boolean found = dfsSearch(startNode, goalNode, visited, path, stepCounter);
        
        if (found) {
            System.out.println("Tujuan " + goalNode + " ditemukan");
            System.out.print("Rute: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" → ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Tujuan " + goalNode + " tidak ditemukan");
        }
    }
    
    private boolean dfsSearch(String current, String goal, Set<String> visited, List<String> path, int[] stepCounter) {
        visited.add(current);
        path.add(current);
        System.out.println("Langkah " + stepCounter[0] + ": Kunjungi " + current);
        stepCounter[0]++;
        
        if (current.equals(goal)) {
            return true;
        }   
        List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
        Collections.sort(neighbors); 
        
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfsSearch(neighbor, goal, visited, path, stepCounter)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
    
    public void printGraph() {
        System.out.println("Struktur Pohon Graf :");
        for (String node : graph.keySet()) {
            System.out.print(node + " -> ");
            List<String> neighbors = graph.get(node);
            System.out.println(String.join(", ", neighbors));
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    	System.out.println("Nama: Deriel Chaerahman");
        System.out.println("NIM : 2411533007");
        System.out.println();
        TugasSearchingGraf graf = new TugasSearchingGraf();
        graf.printGraph();
        graf.search("A", "G");
    }
}
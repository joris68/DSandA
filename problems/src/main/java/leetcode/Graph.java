package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/*Graphs consist of vertices (nodes) ands arcs (edges) 
 * In a directed Graph we have directions going from node to node
 * Graphs can be represented using an adjency matrix or adjency list
 * In this case we have a map: mapping from a node to all adjacent ones
 * 
 * 
*/

public class Graph {

    private Map<Node, List<Node>> adjNodes;

    public Graph() {
        adjNodes = new HashMap<>();
    }


    // getter and setter for 
    public Map<Node, List<Node>> getAdjNodes() {
         return adjNodes;
    }
    public void setAdjNodes(Map<Node, List<Node>> adjNodes) {
         this.adjNodes = adjNodes;
    }

    // add as node to the list, if not int the map
    void addNode(String label) {

        adjNodes.putIfAbsent(new Node(label), new ArrayList<Node>());
    }
    
    //
    void removeNode(String label) {
        Node v = new Node(label);
        // takes away all relationships in the adjency lists
        adjNodes.values().stream().forEach(e -> e.remove(v));
        // removes the key from the map
        adjNodes.remove(new Node(label));
    }

    void addEdge(String label1, String label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        adjNodes.get(v1).add(v2);
        adjNodes.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2){
        Node v1 = new Node (label1);
        Node v2 = new Node (label2);

        // wir müssen es quasi in beide Richtungen updaten
        List <Node> v1List = adjNodes.get(v1);
        List <Node> v2List = adjNodes.get(v2);
        if (v1List != null){
            v1List.remove(v1);
        }
        if(v2List != null){
            v2List.remove(v2);
        }
    }

    /*
     * Takes a the adjencyMap and rrepresents it as a String Array
     * Should be zeros ans ones in there
     * keys x keys
     */
    public int [][] toAdjencyMatrix(){

        int lenght = adjNodes.size();
        int [][] result = new int[lenght][lenght];
        // get all keys and store it in an ordered way
        Object[] allNodes1 = adjNodes.keySet().toArray();
        //Set<Node> allNodes2 = new HashSet<>(allNodes1);
        for (int i = 0; i < allNodes1.length; i++){
            // 1. get the values for the first element from the map
            // for each value in the array check if it is in the adjency list and write to int array
            List <Node> relations = adjNodes.get(allNodes1[i]);
            for (int j = 0; j < allNodes1.length; j++){
                // now we need to figure out in which postiton it in in the matrix
                if (relations.contains(allNodes1[j])){
                    //there is a relation between allNodes[j] and this node so should be 1 in the Matrix
                    // now we need to figure out in which postiton it in in the matrix
                    result[i][j] = 1;
                }else{
                    // should be zero 
                    result[i][j] = 0;
                }
            }
        }
        return result;

    }

    public static void prettyPrintMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mark");
        graph.addNode("Rob");
        graph.addNode("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        int [][] matrix = graph.toAdjencyMatrix();

        Graph.prettyPrintMatrix(matrix);
        
    }


    private class Node{

        String label;

        Node(String label) {
            this.label = label;
        }

        // to work with Java collections we need to implement equals and hashcode function

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node other = (Node) obj;
            return Objects.equals(label, other.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }
   
}

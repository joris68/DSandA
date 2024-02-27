package leetcode;

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


    // getter and setter for 
    public Map<Node, List<Node>> getAdjNodes() {
         return adjNodes;
    }
    public void setAdjNodes(Map<Node, List<Node>> adjNodes) {
         this.adjNodes = adjNodes;
    }

    void addVertex(String label) {
        adjNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }
    
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
            
        }


    }



    private class Node{
        String label;
        Node(String label) {
            this.label = label;
        }
        // to work with Java collections we need to implement equals and hashcode function

        @Override
        public boolean equals(Object obj) {
             // TODO Auto-generated method stub
             return super.equals(obj);
        }

        @Override
        public int hashCode() {
             // TODO Auto-generated method stub
             return super.hashCode();
        }

    }
   
}

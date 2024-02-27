package leetcode;



public class BTree {

     public Node root;

     public BTree(){
          this.root = null;
     }

     public void insert(int value) {
          root = insertRecursively(root, value);
     }
  
      private Node insertRecursively(Node node, int value) {
          if (node == null) {
              return new Node(value, null, null);
          }
  
          if (value > node.value) {
              node.right = insertRecursively(node.right, value);
          } else {
              node.left = insertRecursively(node.left, value);
          }
  
          return node;
     }

     // this is an inner class embedded class
     private class Node {
          private int value;
          private Node left;
          private Node right;
  
          public Node(int value, Node left, Node right) {
              this.value = value;
              this.left = left;
              this.right = right;
          }
     }


}

package leetcode;

import java.util.LinkedList;

class MyQueue {

    LinkedList<Integer> stack;


    public MyQueue() {
        this.stack = new LinkedList<Integer>(); 
    }
     
    public void push(int x) {
        this.stack.add(x);
    }
     
    public int pop() {   
        return this.stack.remove();
    }
     
    public int peek() {
        return this.stack.get(0);
    }
     
    public boolean empty() {
        return this.stack.isEmpty();       
    }
 }
 
 /**
  * Your MyQueue object will be instantiated and called as such:
  * MyQueue obj = new MyQueue();
  * obj.push(x);
  * int param_2 = obj.pop();
  * int param_3 = obj.peek();
  * boolean param_4 = obj.empty();
  */
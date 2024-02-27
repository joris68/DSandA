package leetcode;


public class MergingLists {

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          // Create a dummy node to start the merged list
          ListNode dummy = new ListNode(-1);
          // Create a pointer to traverse the merged list
          ListNode current = dummy;
      
          // Traverse both lists simultaneously
          while (list1 != null && list2 != null) {

              if (list1.val < list2.val) {
                  // If the value in list1 is smaller, add it to the merged list
                  current.next = list1;
                  list1 = list1.next;
              } else {
                  // If the value in list2 is smaller or equal, add it to the merged list
                  current.next = list2;
                  list2 = list2.next;
              }
              // Move the pointer forward in the merged list
              current = current.next;
          }
      
          // Add remaining nodes from list1 or list2 if any
          // das ist nicht richtig glaueb ich
          if (list1 != null) {
              current.next = list1;
          } else {
              current.next = list2;
          }
      
          // Return the merged list (excluding the dummy node)
          return dummy.next;
      }

      public ListNode mergeTwoListouter(ListNode list1, ListNode list2) {
          ListNode dummy = new ListNode(-1);
          // Create a pointer to traverse the merged list
          ListNode current = dummy;
      
          return mergeTwoListinner(current, list1, list2);
      }
      
      public ListNode mergeTwoListinner(ListNode current, ListNode list1, ListNode list2) {
          // Base case: if either list1 or list2 becomes null, return the other list
          if (list1 == null) {
              current.next = list2;
              return current.next;
          }
          if (list2 == null) {
              current.next = list1;
              return current.next;
          }
      
          // Compare values of list1 and list2, and merge accordingly
          if (list1.val < list2.val) {
              current.next = list1;
              mergeTwoListinner(current.next, list1.next, list2);
          } else {
              current.next = list2;
              mergeTwoListinner(current.next, list1, list2.next);
          }
          return current.next; // Return the merged list
      }






     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     }
       
}

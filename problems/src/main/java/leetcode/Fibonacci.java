package leetcode;

public class Fibonacci {

     public static int fiboouter(int number){
          if (number == 0){
               return 0;
          }else if (number == 1){
               return 1;
          }
          return fiboInner(0, 1, number);
     }

     public static int fiboInner(int first, int second ,int number){
          
          if (number > 0){
               return fiboInner(second, (second +first), number -1);
          }else{
               return second;
          }

     }

     public static void main(String[] args) {
          int a=fiboouter(4);
          System.out.println(a);
     }
     
}

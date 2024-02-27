package leetcode;

import java.util.Arrays;

public class BinarySerach {
     
     // soll den index zurückgeben von dem int []
     public int searchArrayouter(int[] array, int searchValue) {
          return searchArray(array, searchValue, 0, array.length - 1);
     }
      
     private int searchArray(int[] array, int searchValue, int left, int right) {
          if (left > right) {
              return -1; // Element not found
          }
      
          int middle = left + (right - left) / 2;
      
          if (array[middle] == searchValue) {
              return middle; // Element found
          } else if (searchValue < array[middle]) {
              return searchArray(array, searchValue, left, middle - 1); // Search in the left half
          } else {
              return searchArray(array, searchValue, middle + 1, right); // Search in the right half
          }
     }

     public int[] halbiereArray(int[] array, int middle, boolean lower) {
          if (lower) {
              return Arrays.copyOfRange(array, 0, middle); 
          } else {
              return Arrays.copyOfRange(array, middle, array.length); 
          }
      }

     public static void main(String[] args) {

          BinarySerach myB = new BinarySerach();
          
          int[] sortedArray = {1, 3, 5, 7, 9, 11};

          int index = myB.searchArrayouter(sortedArray, 9);

          System.out.println(index);


     }



}

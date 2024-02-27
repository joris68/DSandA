package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import org.drools.core.util.Triple;

public class TheeSome {

     public LinkedList<LinkedList<Integer>> threeSum(int[] nums) {

          LinkedList<LinkedList<Integer>> outer = new LinkedList<>();

          HashSet<int []> tripleSet = new HashSet<>();


          int upper = nums.length;
          for (int i = 0; i < upper; i++){
               for (int j = 0; j < upper; j++){
                    for(int k= 0; k < upper ; k++){
                         if (nums[i] +  nums[j] + nums [k] == 0 ){
                              if ( j != i && k != j && i != k){
                                   int [] myArray = new int[]{i, j, k};

                                   if (containsArray(tripleSet, myArray)){
                                        continue;

                                   }else{
                                        tripleSet.add(myArray);
                                        LinkedList<Integer> inner = new LinkedList<>();
                                        inner.add(i);
                                        inner.add(j);
                                        inner.add(k);
                                        outer.add(inner);
                                   }               
                              }
                         }
                    }
               }
          }
        return outer;
    }

    public boolean containsArray(HashSet<int[]> set, int[] array) {
        for (int[] arr : set) {
            if (Arrays.equals(arr, array)) {
                return true;
            }
        }
        return false;
    }

    // should 
    public void addAllPossibilities(HashSet<int[]> set, int[] array){


    }


    public static void main(String[] args) {

     int [] nums = {-1,0,1,2,-1,-4};
     TheeSome my_three = new TheeSome();

     LinkedList<LinkedList<Integer>> solution = my_three.threeSum(nums);

     for (LinkedList<Integer> innerList : solution) {
          for (Integer element : innerList) {
              System.out.print(element + " ");
          }
          System.out.println();
      }



     
    }
     
}

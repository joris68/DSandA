package leetcode;

import java.util.ArrayList;

public class medianProblem {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {

          int a;
          if (nums1.length >= nums2.length){
               a = nums1.length;
          }else{
               a = nums2.length;
          }

          int [] merged = new int [nums1.length + nums2.length];
          int merged_ind = 0;
          int index = 0;
          int j = 0;
         while (j < a){
               if (nums1[j] >= nums2 [index]){
                    merged[merged_ind] = nums2[index];
                    index++;
               }else{
                    merged[merged_ind] = nums1[j];
                    j++;
               }
               merged_ind++;
          }

          if (merged_ind < merged.length-1){
               if (nums1.length >= nums2.length){
                    for (int i = index; i< merged.length; i++){
                         merged[merged_ind] = nums2[i];
                    }

               }else{
                    for (int i = index; i< merged.length; i++){
                         merged[merged_ind] = nums1[i];
                    }
               }
          }


          for (int i = 0; i< merged.length; i++){
               System.out.println(merged[i]);
          }

          if ( merged.length % 2 == 0){

               double first = merged[(merged.length / 2) -1];
               double second = merged[(merged.length / 2)];

               return (first + second) / 2;

          }else{
               return merged[merged.length/2];
          }
        
     }

     public static void main(String[] args) {
          medianProblem mine = new medianProblem();

          int [] nums1 = {1,2,4,8,11};
          int [] nums2 = {3,9,15};

          double result = mine.findMedianSortedArrays(nums1, nums2);

          System.out.println(result);

     }
}

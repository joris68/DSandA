package leetcode;

class RemoveDuplicates {

     public int removeDuplicates(int[] nums) {

          int speicher = -1000;
          int counter = 0;

          for (int i = 0; i < nums.length ; i++){

               if (speicher != nums[i]){
                    speicher = nums[i];
                    counter++;
               }else if(speicher == nums[i]){
                    // nothing happens
                    continue;
               }

          }

          return counter;
         
     }

     public static void main(String[] args) {
          int [] a = {0,0,1,1,1,2,2,3,3,4};

          RemoveDuplicates my_Solution = new RemoveDuplicates();

          System.out.println(Integer.toString(my_Solution.removeDuplicates(a)));
     }
 }

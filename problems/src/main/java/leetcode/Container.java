package leetcode;

public class Container {

     public int maxArea(int[] height) {

          //int toReturn = 0;
          int currentMax = 0;
          for (int i = 0; i < height.length; i++){
               for (int j = i + 1; j < height.length; j++){
                    int a = height[i];
                    int b = height[j];
                    int res;

                    if (a > b) {
                         res = b*(j-i);
                    }else{
                         res = a*(j-i);
                    }
                    if (res > currentMax){
                         currentMax = res;
                    }
               }
          }

          return currentMax;
        
     }

     
}

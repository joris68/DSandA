package leetcode;

import java.util.Arrays;

public class CommonPrefix {
     
     // longest prefix <= shortest word in string


     // all Strings are lowercase
     public String longestCommonPrefix(String[] strs) {

          int [] lengths = extractLenghts(strs);
          int longestPossiblePrefix = linearSearch(lengths);

          String prefix = "";

          for (int i = 0; i < longestPossiblePrefix; i++){

               String letsSee = prefix(strs, i, i+1);

               if (!letsSee.equals("")){
                    prefix = prefix + letsSee;
               }else{
                    return "";
               }

          }
          
        return prefix;
     }

     public int [] extractLenghts(String[] strings){

          int[] lentghs = new int[strings.length];

          for (int i = 0; i < strings.length; i++){
               lentghs[i] = strings[i].length();
          }

          return lentghs;
     }

     // implementing linear search
     public int linearSearch(int[] lengthts){

          int dummy = 0;
          int counter = 0;
          while (counter < lengthts.length){
               if (lengthts[counter] > dummy){
                    dummy = lengthts[counter];
               }
               counter++;
          }

          return dummy;

     }

     public String prefix(String[] strings, int beginIndex, int endIndex){

          String prefix = strings[0].substring(beginIndex, endIndex);

          for (int i = 0; i < strings.length; i++){
               String pre = strings[i].substring(beginIndex, endIndex);


               if (!prefix.equals(pre)){
                    return "";
               }
          }

          return prefix;
          
     }

     public String longestCommonPrefix2(String[] strs) {
          if (strs == null || strs.length == 0) {
              return "";
          }
  
          String prefix = strs[0];
          for (int i = 1; i < strs.length; i++) {
              while (!strs[i].startsWith(prefix)) {
                  prefix = prefix.substring(0, prefix.length() - 1);
                  if (prefix.isEmpty()) {
                      return "";
                  }
              }
          }
          return prefix;
      }

     public static void main(String[] args) {
          CommonPrefix myP = new CommonPrefix();

          String[] strs = {"flower", "flow", "flight"};

          String prefix = myP.longestCommonPrefix(strs);

          System.out.println(prefix);
          
          

     }
     
}

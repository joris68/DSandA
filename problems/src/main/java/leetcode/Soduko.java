package leetcode;

import java.util.Set;
import java.util.HashSet;

public class Soduko {

     // jede Reihe schauen, ob werte einzeln sind --> vielleicht mit Set?
     // jede Spalte schauen, ob werte einzeln sind 
     // wie bekomme ich die sub matrixen heraus?
     public boolean isValidSudoku(char[][] board) {

          // check the rows first
          for (int i = 0; i < board.length; i++){

               char[] column = extractColumn(board, i);

               boolean rowb = checkRow(board[i]); 
               boolean colb = checkRow(column);

               if ( !rowb || !colb){
                    return false;
               }
          }

          // we will have 9 subMatrixes 
          int [] indexes = {0,0,0,3,0,6,3,0,3,3,3,6,6,0,6,3,6,6};
          for (int i = 0; i< 9; i++){

               char [][] sub = extractSubMatrix(board, indexes[i], indexes[i+1], 3, 3);

               char [] flatSub = flatten(sub);

               boolean result = checkRow(flatSub);
               if(!result){
                    return false;
               }

          }

          return true;
  
     }

     // we know that a field is 9 x 9 and we want to extract 9 sub matrices with different startRows and startCols
     // numRows and numCols will always be three in our case

     public static char[][] extractSubMatrix(char[][] originalMatrix, int startRow, int startCol, int numRows, int numCols) {
          char[][] subMatrix = new char[numRows][numCols];
  
          for (int i = 0; i < numRows; i++) {
              for (int j = 0; j < numCols; j++) {
                  subMatrix[i][j] = originalMatrix[startRow + i][startCol + j];
              }
          }
  
          return subMatrix;
     }

     public char[] flatten(char[][] array){
          
          // assumiing quadratic input
          char [] result = new char[array.length * array[0].length];
          int index = 0;

          for (int i = 0; i < array.length; i++){
               for (int j = 0; j < array[i].length; j++){
                    result[index] = array[i][j];
                    index++;
               }
          }
          return result;
     }
  

     public boolean checkRow(char [] row) {

          HashSet <Character> mySet = new HashSet<>();

          for (int i = 0; i < row.length; i++){

               if (row[i] == '.'){
                    continue;
               }else{ 
                    if (!mySet.contains(row[i]))
                         mySet.add(row[i]);
                    else{
                         // have gotten duplicate entry in the row ==> false state !
                         return false;
                    }
               }
          }
          return true;
     }

     public char [] extractColumn( char[][] matrix ,int columnIndex){

          int numRows = matrix[0].length;

          char[] column = new char[numRows];
          for (int i = 0; i < numRows; i++) {
               column[i] = matrix[i][columnIndex];
          }
          return column;
     }

     public static void main(String[] args) {
          
          Soduko myS = new Soduko();

          char[][] initialState = {
               {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
               {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
               {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
               {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
               {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
               {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
               {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
               {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
               {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
           };

           boolean result = myS.isValidSudoku(initialState);

           System.out.println(result);


     }
     
}

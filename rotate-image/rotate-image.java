import java.util.ArrayList;
import java.util.List;
//in-place 

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
        
        //reverse
       for(int row=0; row<n/2; row++){
           int[] tmp = matrix[row];
           matrix[row]=matrix[n-1-row];
           matrix[n-1-row]=tmp;
       }
        
        //swap symmetry
        for(int row = 0; row<n; row++){
            for(int col= row+1; col<n; col++){
              int tmp = matrix[row][col];
               matrix[row][col]= matrix[col][row];
               matrix[col][row] = tmp;
            }
        }        
    }
}
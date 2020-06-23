package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-25 21:04
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;

        while (true) {
            if(n < 0 || m > matrix.length - 1) return false;
            if(matrix[m][n] == target)return true;
            else if(matrix[m][n] > target) n -= 1;
            else m += 1;
        }



    }
}

package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-26 21:02
 */
public class rotate2 {

    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int cols = matrix[0].length;
        int len = (matrix.length  + 1) / 2;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < cols - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[cols - j][i];
                matrix[cols - j][i] = matrix[cols - i][cols - j];
                matrix[cols - i][cols - j] = matrix[j][cols - i];
                matrix[j][cols - i] = temp;
            }
        }


    }
}

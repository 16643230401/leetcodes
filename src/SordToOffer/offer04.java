package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-25 21:08
 */
public class offer04 {
    public static void main(String[] args) {
        int[][] matrix = {{-1,100}
        };


        int target = 100;

        offer04 ans = new offer04();
        System.out.println(ans.findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;

        while(right >= 0 && left < matrix.length) {
            if(target == matrix[left][right]) return true;
            else if (target > matrix[left][right]) {
                left ++;
            } else {
                right --;
            }
        }

        return false;



    }

}

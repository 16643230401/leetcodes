package EveryDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-02 21:34
 */
public class kthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int n = matrix.length;
        int mid;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        if (left == right ) return left;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (left < right) {
            mid = (left + right) / 2;
            for (int i = 0; i < matrix.length; i++) {
                int j = 0;
                for (j = 0; j < matrix.length; j++) {
                    if(matrix[i][j] > mid) break;
                }
                sum += j;
                if(j > 0) {
                    max = Math.max(matrix[i][j - 1], max);
                }
            }
            if(sum == k) return max;
            else if(sum < k) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}

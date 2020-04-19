package test;

/**
 * 63. 不同路径 II
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-06 15:18
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        uniquePathsWithObstacles uniquePathsWithObstacles = new uniquePathsWithObstacles();
        int[][] arr = {{0}};
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        int flag = 0;
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) flag = 1;
            arr[i][0] = flag == 1 ? 0 : 1;
        }
        flag = 0;
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) flag = 1;
            arr[0][i] = flag == 1 ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = (obstacleGrid[i][j] == 1 ? 0 : arr[i - 1][j]) + (obstacleGrid[i][j] == 1 ? 0 : arr[i][j - 1]);
            }
        }
        return arr[m - 1][n - 1];
    }
}

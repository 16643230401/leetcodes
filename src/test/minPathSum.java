package test;

/**
 * 64. 最小路径和
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-07 11:16
 */
public class minPathSum {

    public static void main(String[] args) {
        minPathSum minPathSum = new minPathSum();
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum.minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j],grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];

    }
}

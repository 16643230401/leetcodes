package EveryDay;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-06 22:12
 */
public class uniquePathsIII {

    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int left = 0;
        int right = 0;
        //计算可走可走格子数
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 0) count ++;
                if(grid[i][j] == 1) {
                    left = i;
                    right = j;
                }
            }
        }
        return dfs(count, left, right, grid);
    }


    public int  dfs(int step, int i, int j, int[][] grid) {
        int ret = 0;
        if(i >= grid.length ||  i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == -1 || grid[i][j] == 1) return 0;
        if(grid[i][j] == 2) {
            if(step == 0) {
                return 1;
            }
            return 0;
        }
        grid[i][j] = -1;
        ret += dfs(step - 1, i - 1, j, grid);
        ret += dfs(step - 1, i, j + 1, grid);
        ret += dfs(step - 1, i + 1, j, grid);
        ret += dfs(step - 1, i, j - 1, grid);
        grid[i][j] = 0;

        return ret;
    }
}

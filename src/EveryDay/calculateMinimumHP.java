package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-23 20:54
 */
public class calculateMinimumHP {

    public static void main(String[] args) {
        int[][] ask = {{2,-3,3}, {-5, -10, 1}, {10, 30, -5}};
        calculateMinimumHP calculateMinimumHP = new calculateMinimumHP();
        calculateMinimumHP.calculateMinimumHP(ask);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0) return 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] ans = new int[rows][cols];
        ans[rows - 1][cols - 1] = Math.max(0, -dungeon[rows - 1][cols - 1]);

        for (int i = rows - 2; i >= 0; i--) {
            ans[i][cols - 1] = Math.max(ans[i + 1][cols - 1], ans[i + 1][cols - 1] - dungeon[i][cols - 1]);
            if(ans[i][cols - 1] < 0) ans[i][cols - 1] = 0;
        }

        for (int i = cols - 2; i >= 0; i--) {
            ans[rows - 1][i] = Math.max(ans[rows - 1][i + 1], ans[rows - 1][i + 1] - dungeon[rows - 1][i]);
            if(ans[rows - 1][i] < 0) ans[rows - 1][i] = 0;
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                ans[i][j] = Math.min(ans[i + 1][j], ans[i][j + 1]) - dungeon[i][j];
                if(ans[i][j] < 0) ans[i][j] = 0;
            }
        }


        return ans[0][0] < 0 ? 1 : ans[0][0] + 1;
    }
}

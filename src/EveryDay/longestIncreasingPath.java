package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-26 19:07
 */
public class longestIncreasingPath {


    /**
     * 垃圾DFS
     * @param matrix
     * @return
     */
//    public int longestIncreasingPath(int[][] matrix) {
//        if(matrix.length == 0) return 0;
//        int[][] visit = new int[matrix.length][matrix[0].length];
//
//
//        int ans = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                ans = Math.max(ans, dfs(i, j, matrix, visit, Integer.MIN_VALUE) - 1);
//            }
//        }
//
//        return ans;
//    }
//
//
//    public int dfs(int x, int y, int[][] matrix, int[][] visit, int lastVal) {
//        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= lastVal) return 1;
//
//        if(visit[x][y] != 0) {
//            return visit[x][y] + 1;
//        }
//
//        visit[x][y] = Math.max(dfs(x + 1, y, matrix, visit, matrix[x][y]), Math.max(dfs(x - 1, y, matrix, visit, matrix[x][y]), Math.max(dfs(x, y + 1, matrix, visit, matrix[x][y]), dfs(x, y - 1, matrix, visit, matrix[x][y]))));
//
//        return visit[x][y] + 1;
//    }


    /**
     * 下面是优化垃圾DFS
     */
    int[][] visit;
    int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows;
    int cols;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        initValus(matrix);

        int ans=  0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(0, 0, matrix));
            }
        }

        return ans;
    }

    public int dfs(int x, int y, int[][] matrix){
        if(visit[x][y] != 0) return visit[x][y];
        visit[x][y] = 1;
        int nextX, nextY;
        for (int[] ints : direct) {
            nextX = x + ints[0];
            nextY = y + ints[1];
            if(nextX >=0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[nextX][nextY] > matrix[x][y]) {
                visit[x][y] = Math.max(visit[x][y], dfs(nextX, nextY, matrix) + 1);
            }
        }
        return visit[x][y];
    }

    public void initValus(int[][] matrix){
        rows = matrix.length;
        cols = matrix[0].length;
        visit = new int[rows][cols];
    }
}

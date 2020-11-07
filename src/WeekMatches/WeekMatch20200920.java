package WeekMatches;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-09-20 15:34
 */
public class WeekMatch20200920 {

    public static void main(String[] args) {
        int[][] arr = {{-4,-2,-2,1,-1,4,0,4,3,4,-3,-1,-1,0,0},{1,0,0,-2,-4,-4,-2,4,1,1,-4,-2,-1,-1,-2},{3,-3,0,-1,-4,-1,0,-2,2,4,2,-3,-1,4,-2},{1,3,0,4,-2,-2,3,-4,3,-2,-1,-1,-3,0,-1},{0,-3,-4,0,3,2,-3,-3,-4,-1,3,-1,1,4,3},{-2,1,-1,4,1,-3,2,0,-4,-3,0,-1,0,-3,-3},{4,-2,4,3,-3,3,4,-4,2,-3,1,-4,3,0,-3},{-3,4,-1,-4,-2,-2,-3,3,0,-2,-4,0,4,1,3},{4,-2,2,4,2,-1,-4,-2,3,3,-2,-4,-4,-4,4},{4,1,-1,-2,-2,-3,-2,-3,-4,3,-2,4,1,4,2},{-3,-1,-4,-2,-4,4,-2,-4,4,2,4,2,2,-4,-2},{-3,3,3,4,-1,-3,3,-1,2,4,2,-3,-3,-3,4},{-4,-3,1,-2,4,-3,-4,-1,3,4,-4,-1,0,-4,-4},{-3,0,-2,-2,-4,-1,1,-1,-4,0,-4,4,-2,-2,-4},{2,-4,-3,3,-3,0,4,0,-4,4,-1,-4,-1,3,-4}};
        int[][] arr2 = {{2,4,-3,0,3},{-1,0,3,-2,4},{-3,-3,1,2,-4},{3,4,0,0,1}};
        WeekMatch20200920 w = new WeekMatch20200920();
        System.out.println(w.maxProductPath(arr2));


    }

    int[][] direct = {{-1, 0}, {0, -1}};
    long[][] gridA;
    long[][] gridB;
    int ans = 0;
    int[][] visit;
    public int maxProductPath(int[][] grid) {
        gridA = new long[grid.length][grid[0].length];
        gridB = new long[grid.length][grid[0].length];
        gridA[0][0] = -1;
//        dfs(grid.length - 1, grid[0].length - 1, 1, grid);

        for (int i = 0; i < gridA.length; i++) {
            for (int j = 0; j < gridA[0].length; j++) {
                gridA[i][j] = -1;
            }
        }


        for (int i = 0; i < gridB.length; i++) {
            for (int j = 0; j < gridB[0].length; j++) {
                gridB[i][j] = 1;
            }
        }
        long temp = 1;
        for (int i = 0; i < grid[0].length; i++) {
            temp = temp * grid[0][i];
            if(temp < 0) gridB[0][i] = temp;
            else gridA[0][i] = temp;
        }

        temp = 1;
        for (int i = 0; i < grid.length; i++) {
            temp = temp * grid[i][0];
            if(temp < 0) gridB[i][0] = temp;
            else gridA[i][0] = temp;
        }



        gridA[grid.length - 1][grid[0].length - 1] = -1;


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(gridA[i - 1][j] != -1) {
                    temp = grid[i][j] * gridA[i - 1][j];
                    if(temp == 0 && gridB[i][j] > 0) gridB[i][j] = 0;
                    if (temp < 0) gridB[i][j] = Math.min(gridB[i][j], temp);
                    else gridA[i][j] = Math.max(gridA[i][j], temp);
                }

                if(gridB[i - 1][j] != 1) {
                    temp = grid[i][j] * gridB[i - 1][j];
                    if(temp == 0 && gridB[i][j] > 0) gridB[i][j] = 0;
                    if (temp < 0) gridB[i][j] = Math.min(gridB[i][j], temp);
                    else gridA[i][j] = Math.max(gridA[i][j], temp);
                }

                if(gridA[i][j - 1] != -1) {
                    temp = grid[i][j] * gridA[i][j - 1];
                    if(temp == 0 && gridB[i][j] > 0) gridB[i][j] = 0;
                    if (temp < 0) gridB[i][j] = Math.min(gridB[i][j], temp);
                    else gridA[i][j] = Math.max(gridA[i][j], temp);
                }

                if(gridB[i][j - 1] != 1) {
                    temp = grid[i][j] * gridB[i][j - 1];
                    if(temp == 0 && gridB[i][j] > 0) gridB[i][j] = 0;
                    if (temp < 0) gridB[i][j] = Math.min(gridB[i][j], temp);
                    else gridA[i][j] = Math.max(gridA[i][j], temp);
                }
            }
        }


        for (int i = 0; i < gridA.length; i++) {
            for (int j = 0; j < gridA[0].length; j++) {
                System.out.print(gridA[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < gridA.length; i++) {
            for (int j = 0; j < gridA[0].length; j++) {
                System.out.print(gridB[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < gridA.length; i++) {
            for (int j = 0; j < gridA[0].length; j++) {
                System.out.print(grid[i][j] + "   ");
            }
            System.out.println();
        }


        return (int)(gridA[grid.length - 1][grid[0].length - 1] % 1000000007);

    }


    public void dfs(int x, int y, long val, int[][] grid) {
        if(x < 0 || x > visit.length || y < 0 || y >= visit[0].length || visit[x][y] == 1) return;
        visit[x][y] = 1;
        long temp = val * grid[x][y];
//        if(temp < 0) {
//            gridB[x][y] = Math.min(gridB[x][y], temp);
//        } else {
//            gridA[x][y] = Math.max(gridA[x][y], temp);
//        }
        if(temp < 0) {
            if(temp > gridB[x][y]) return;
            gridB[x][y] = temp;
        } else {
            if(temp < gridA[x][y]) return;
            gridA[x][y] = temp;
        }
//        if(temp > gridA[x][y]) {
//            gridA[x][y] = temp;
//        }else if(temp < gridB[x][y]) {
//            gridB[x][y] = temp;
//        } else {
//            return;
//        }
        for (int i = 0; i < direct.length; i++) {
            dfs(x + direct[i][0], y + direct[i][1], temp, grid);
        }
        visit[x][y] = 0;
    }
}

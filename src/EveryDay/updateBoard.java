package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-20 23:18
 */
public class updateBoard {
    int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};



    char[][] arr;
    public char[][] updateBoard(char[][] board, int[] click) {
        arr = board;
        dfs(click[0], click[1]);
        return arr;
    }

    public char rayCount(int x, int y){
        char count = '0';
        for (int i = 0; i < dir.length; i++) {
            int xDir = x + dir[i][0];
            int yDir = y + dir[i][1];
            if(xDir < 0 || yDir < 0 || xDir >= arr.length || yDir > arr[0].length) continue;
            if(arr[xDir][yDir] == 'M') count += 1;
        }
        return count;
    }

    public void dfs(int x, int y){
        if(x < 0 || y < 0 || x >= arr.length || y > arr[0].length || arr[x][y] == 'B') return;
        char rayCount = rayCount(x, y);
        if(rayCount != 0) {
            arr[x][y] = rayCount;
            return;
        }
        arr[x][y] = 'B';
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x, y - 1);
    }
}

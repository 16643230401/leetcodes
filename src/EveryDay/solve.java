package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-11 21:30
 */
public class solve {


    int[][] visit;
    char[][] bo;
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        visit = new int[board.length][board[0].length];
        bo = board;

        for (int i = 0; i < bo.length; i++) {
            dfs(i, 0);
            dfs(i, bo[0].length - 1);
        }

        for (int i = 0; i < bo[0].length; i++) {
            dfs(0, i);
            dfs(bo.length - 1, i);
        }

        for (int i = 1; i < bo.length - 1; i++) {
            for (int j = 1; j < bo[0].length - 1; j++) {
                if(bo[i][j] == 'O' && visit[i][j] == 0) {
                    bo[i][j] = 'X';
                }
            }
        }

        board = bo;



    }


    public void dfs(int x, int y) {
        if(x < 0 || y < 0 || x == visit.length || y == visit[0].length || bo[x][y] == 'X' || visit[x][y] == 1) return;

        visit[x][y] = 1;

        dfs(x, y - 1);
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x - 1, y);
    }
}

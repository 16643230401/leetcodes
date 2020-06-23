package mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-25 21:02
 */
public class isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rowMap = new HashMap[9];
        Map<Integer, Integer>[] columnMap = new HashMap[9];
        Map<Integer, Integer>[] bosMap = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rowMap[i] = new HashMap<>();
            columnMap[i] = new HashMap<>();
            bosMap[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                if(rowMap[i].get(board[i][j] - '0') != null && rowMap[i].get(board[i][j] - '0') == 1) return false;
                rowMap[i].put(board[i][j] - '0', 1);
                if(columnMap[j].get(board[i][j] - '0') != null && columnMap[j].get(board[i][j] - '0') == 1) return false;
                columnMap[j].put(board[i][j] - '0', 1);
                int num =  i / 3 + (j / 3) * 3;
                if(bosMap[num].get(board[i][j] - '0') != null && bosMap[num].get(board[i][j] - '0') == 1) return false;
                bosMap[num].put(board[i][j] - '0', 1);
            }
        }

        return true;

    }

}

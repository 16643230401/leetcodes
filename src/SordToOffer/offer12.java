package SordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-30 21:24
 */
public class offer12 {

    public boolean exist(char[][] board, String word) {

        if(board.length == 0 || board[0].length == 0) return false;
        char[] arr = word.toCharArray();
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == arr[0] && find(map, board, arr, i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean find(Map<String, Character> map, char[][] board, char[] arr, int x, int y, int pointer) {
        if(pointer >= arr.length) return true;
        if(map.keySet().contains(x + "_" + y)) return false;
        map.put(x+ "_" + y, board[x][y]);
        if(y > 0 && board[x][y - 1] == arr[pointer]) {
            if(pointer + 1 == arr.length || find(map, board, arr, x, y - 1, pointer + 1)) return true;
        }
        if(x < board.length - 1 && board[x + 1][y] == arr[pointer]) {
            if(pointer + 1 == arr.length || find(map, board, arr, x + 1, y, pointer + 1)) return true;
        }
        if(y < board[0].length - 1 && board[x][y + 1] == arr[pointer]) {
            if(pointer + 1 == arr.length || find(map, board, arr, x, y + 1, pointer + 1)) return true;
        }
        if(x > 0 && board[x - 1][y] == arr[pointer]) {
            if(pointer + 1 == arr.length || find(map, board, arr, x - 1, y, pointer + 1)) return true;
        }
        map.remove(x + "_" + y);
        return false;
    }
}

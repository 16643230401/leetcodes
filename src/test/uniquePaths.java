package test;

/**
 * 62. 不同路径
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-06 10:43
 */
public class uniquePaths {

    public static void main(String[] args) {
        uniquePaths uniquePaths = new uniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }

    static int ans = 0;
//    public int uniquePaths3(int m, int n) {
//        if(m <= 1 || n <= 1) return 0;
//        solution(m,n,0,0);
//        return ans;
//    }

//    public void solution(int m, int n, int x, int y) {
//        if(x == m - 1 && y == n - 1) {
//            ans += 1;
//            return;
//        }
//        if(x < m - 1) {
//            solution(m, n, x + 1, y);
//        }
//
//        if(y < n - 1) {
//            solution(m, n, x, y + 1);
//        }
//    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if(m == 0 && n == 0) return 0;

        return solution(m - 1, n - 1);
    }

    public int solution(int x, int y) {
        if(x <= 0 || y <= 0) {
            return 1;
        }
        return solution(x - 1, y) + solution(x, y - 1);

    }
}

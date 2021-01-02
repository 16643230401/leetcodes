package laterWMS.WeekMatch20200705;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-05 11:19
 */
public class numSubmat {

    public int numSubmatLong(int[][] mat) {
        int[][][][] dp = new int[mat.length][mat[0].length][mat.length][mat[0].length];
        for (int i1 = 0; i1 < mat.length; i1++) {
            for (int j1 = 0; j1 < mat[0].length; j1++) {
                if(mat[i1][j1] == 1) {
                    dp[i1][j1][i1][j1] = 1;
                }
            }
        }

        for (int i1 = 0; i1 < mat.length; i1++) {
            for (int j1 = 0; j1 < mat[0].length; j1++) {
                for (int i2 = i1 + 1; i2 < mat.length; i2++) {
                    if(mat[i2][j1] == 0 || dp[i1][j1][i2 - 1][j1] == 0) break;
                    dp[i1][j1][i2][j1] = 1;
                }

                for (int j2 = j1 + 1; j2 < mat[0].length; j2++) {
                    if(dp[i1][j1][i1][j2 - 1] == 0 || mat[i1][j2] == 0) break;
                    dp[i1][j1][i1][j2] = 1;
                }


                for (int i2 = i1 + 1 ; i2 < mat.length; i2++) {
                    for (int j2 = j1 + 1; j2 < mat[0].length; j2++) {
                        if(dp[i1][j1][i2][j2 - 1] == 0 || dp[i1][j1][i2 - 1][j2] == 0 || mat[i2][j2] == 0) break;
                        dp[i1][j1][i2][j2] = 1;
                    }
                }
            }
        }

        int ans = 0;

        for (int i1 = 0; i1 < mat.length; i1++) {
            for (int j1 = 0; j1 < mat[0].length; j1++) {
                for (int i2 = 0; i2 < mat.length; i2++) {
                    for (int j2 = 0; j2 < mat[0].length; j2++) {
                        if(dp[i1][j1][i2][j2] == 1) ans += 1;
                    }
                }
            }
        }

        return ans;
    }


    public int numSubmatError(int[][] mat) {
        int ans = 0;
        for (int i1 = 0; i1 < mat.length; i1++) {
            for (int j1 = 0; j1 < mat[0].length; j1++) {
                if(mat[i1][j1] == 1) {
                    ans += 1;
                }
            }
        }

        for (int i1 = 0; i1 < mat.length; i1++) {
            for (int j1 = 0; j1 < mat[0].length; j1++) {
                if(mat[i1][j1] == 0) break;
                for (int j2 = j1 + 1; j2 < mat[0].length; j2++) {
                    if(mat[i1][j2] == 0) break;
                    ans += 1;
                }

                for (int i2 = i1 + 1; i2 < mat.length; i2++) {
                    if(mat[i2][j1] == 0) break;
                    ans += 1;
                }

                int n = mat[0].length;
                for (int i2 = i1 + 1; i2 < mat.length; i2++) {
                    for (int j2 = j1 + 1; j2 < n; j2++) {
                        if(mat[i2 - 1][j2] == 0 || mat[i2][j2 - 1] == 0 || mat[i2][j2] == 0) {
                            n = j2;
                            break;
                        }
                        ans += 1;
                    }
                }


            }
        }




        return ans;
    }

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(mat[i][j] > 0) mat[i][j] = mat[i][j - 1] + 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int addNum = 151;
                for (int k = i; k >= 0; k--) {
                    addNum = Math.min(mat[i][j], addNum);
                    ans += addNum;
                }
            }
        }
        return ans;
    }
}

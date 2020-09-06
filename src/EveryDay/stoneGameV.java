package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-23 15:36
 */
public class stoneGameV {

    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        int[][] dp = new int[len][len];
        int[][] sum = new int[len][len];
        for (int i = 1; i < len; i++) {
            stoneValue[i] += stoneValue[i - 1];
        }

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j; k < i; k++) {
//                    if(sum[j][k] == 0) sum[j][k] = getSum(stoneValue, j, k);
//                    int j2k = sum[j][k];
//                    if(sum[k + 1][i] == 0) sum[k + 1][i] = getSum(stoneValue, k + 1, i);
//                    int k2i = sum[k + 1][i];
                    int j2k = stoneValue[k] - j > 0 ? stoneValue[j - 1] : 0;
                    int k2i = stoneValue[i] - stoneValue[k];
                    if(k2i > j2k) {
                        dp[j][i] = Math.max(dp[j][i], j2k + dp[j][k]);
                    } else if(k2i < j2k){
                        dp[j][i] = Math.max(dp[j][i], k2i + dp[k + 1][i]);
                    } else {
                        dp[j][i] = Math.max(dp[j][i], k2i + Math.max(dp[j][k], dp[k + 1][i]));
                    }
                }
            }
        }

        return dp[0][len - 1];
    }

    public int getSum(int[] arr, int x, int y) {
        int ans = 0;
        for (int i = x; i <= y; i++) {
            ans += arr[i];
        }
        return ans;
    }
}

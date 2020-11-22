package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-24 22:27
 */
public class maxCoins {


    /**
     * 戳气球
     * 蒙了
     * @param nums
     * @return
     */

    public int maxCoins(int[] nums) {

        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] val = new int[len + 2];
        val[0] = val[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = 2; i < len + 1; i++) {
            for (int j = i - 2; j >= 0; j--) {
                for (int k = j + 1; k < i; k++) {
                    dp[j][i] = Math.max(dp[j][i], val[i] * val[j] * val[k] + dp[j][k] + dp[k][i]);
                }
            }
        }

        return dp[0][len + 1];
    }
}

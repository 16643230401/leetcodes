package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-13 20:35
 */
public class maxProfit {


    //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + p[i])
    //dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - p[i])

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}

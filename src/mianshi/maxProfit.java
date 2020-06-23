package mianshi;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-03 18:36
 */
public class maxProfit {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];


        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
        }

        return dp[0][prices.length - 1];
    }
}

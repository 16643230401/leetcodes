package test;

/**
 * 121. 买卖股票的最佳时机
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-11 20:35
 */
public class maxProfit {

    public static void main(String[] args) {
        maxProfit maxProfit = new maxProfit();
        int[] arr = {2,4,1,4,6,3,8,5,6,7,4,7};
        System.out.println(maxProfit.maxProfit4(5, arr));

    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int ans = 0;
        int minPri = prices[0];
        int maxPri = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < minPri) {
                minPri = prices[i];
                maxPri = prices[i];
            } else if(prices[i] > maxPri){
                maxPri = prices[i];
                ans = Math.max(ans, maxPri - minPri);
            }
        }

        return ans;
    }

    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];

    }


    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit3(int[] prices) {
        if(prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[i];
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }


        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }


        return dp[prices.length - 1][2][0];
    }

    public int maxProfit3_optimize(int[] prices) {
        if(prices.length == 0) return 0;
        int dpi0_0 = 0, dpi0_1 = -prices[0];
        int dpi1_0 = 0, dpi1_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dpi1_0 = Math.max(dpi1_1 + prices[i], dpi1_0);
            dpi1_1 = Math.max(dpi1_1, dpi0_0 - prices[i]);
            dpi0_0 = Math.max(dpi0_1 + prices[i], dpi0_0);
            dpi0_1 = Math.max(dpi0_1, -prices[i]);
        }

        return dpi1_0;
    }

    public int maxProfit4(int k, int[] prices) {
        if(prices.length == 0) return 0;

        int n = 0;
        if(k > prices.length / 2) n = prices.length / 2;
        else n = k;
        int[][] dp = new int[n + 1][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }


        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[j][0] = Math.max(dp[j][1] + prices[i], dp[j][0]);
                dp[j][1] = Math.max(dp[j - 1][0] - prices[i], dp[j][1]);
            }
        }


        return dp[n][0];
    }
}

package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-31 21:39
 */
public class offer14 {

    //动态规划（dp[n] = dp[i] * dp[j] ,  其中i + j = n）
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }

    //贪心算法（找3，若干个3乘积最大，，如果最后剩2的话就若干个3加一个2，如果最后剩1的话就拿出一个三变成4）
    public int cuttingRope2(int n) {
        int mod = n % 3;
        int pow = n / 3;
        if(mod == 1) return (int)Math.pow(3, pow - 1) * 4;
        else if (mod == 2) return (int)Math.pow(3, pow) * 2;
        else return (int)Math.pow(3, pow);
    }



}

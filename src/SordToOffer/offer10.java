package SordToOffer;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-17 21:25
 */
public class offer10 {

    public int fib(int n) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 3] = (dp[(i - 1) % 3] + dp[(i - 2) % 3]) % (1000000007);
        }
        return dp[n % 3];
    }


}
